package task_1.task_9;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task9 {
    public static void main(String[] args) {
        String path = "textRepeat.txt";
        String pathWithException = "text.txt";

        try{
            showCountOfCharacters(path);
            System.out.println("\n---------------------------------");
            showCountOfCharacters(pathWithException);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static private String readFromFile(String path){
        StringBuilder sb = new StringBuilder();
        try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(path))){
            int characters;
            while((characters = reader.read()) != -1){
                sb.append((char)characters);
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
        return  sb.toString();
    }

    static private void showCountOfCharacters(String path) throws Exception {
        String str = readFromFile(path);
        Map<Character, Integer> map = new HashMap<>();
        if(!str.matches("^([A-Za-z]+)$")){
            throw new Exception("\"The string has more than just letters!\"");
        }
        else{
            str.chars()
                    .mapToObj(e -> (char)e)
                    .forEach(e -> {
                        map.merge(e, 1, (i1, i2) -> i1 + i2);
                        if(map.values().stream().reduce((a,b) -> a + b).get() == str.length()){
                            map.forEach((key,value) -> System.out.print(value + "" + key));
                        };
                    });
        }
    }
}
