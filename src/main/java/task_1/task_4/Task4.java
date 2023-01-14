package task_1.task_4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        String path = "text.txt";
        String[] str = readFromFile(path).split("[.,!?\\- \\n\\\"']");
        Stream.of(str)
                .collect(Collectors.groupingBy(e -> e.length()))
                .entrySet()
                .stream()
                .max((o1,o2) -> o1.getKey() - o2.getKey())
                .map(e -> e.getValue())
                .get()
                .forEach(e -> System.out.println(e));
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
}
