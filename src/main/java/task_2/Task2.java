package task_2;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        String path = "The-fixer-George-O---Geor-[ebooksread.com].txt";
        Map<String, Integer> map = new HashMap<>();

        long start2 = System.currentTimeMillis();
        String strBufferInputReader = getStringFromFileBufferInputReader(path);
        Stream.of(strBufferInputReader.split("\\P{LD}"))
                        .forEach(e -> {
                            map.merge(e, 1, Integer::sum);
                            if(map.values().stream().reduce((a, b) -> a + b).get()
                                    == (strBufferInputReader.split("\\P{LD}").length)){
                                map.forEach((key, value) -> {
                                    System.out.printf("%-25s %-5s%n", key, value);
                                });
                            }
                        });
        System.out.println(System.currentTimeMillis() - start2);
    }

    static private String getStringFromFileBufferInputReader(String path){
        StringBuilder sb = new StringBuilder();
        try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(path))){
            int characters;
            while((characters = reader.read()) != -1){
                sb.append((char)characters);
            }
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
        return sb.toString();
    }
}