package task_1.task_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        String path = "text.txt";
        readFromFile(path)
                .stream()
                .forEach(e -> System.out.println(e));
        System.out.println("---------------------SORTED--------------------------------");
        List<String> list = readFromFile(path);
        list.stream()
                .sorted(Comparator.reverseOrder())
                .toList()
                .forEach(e -> System.out.println(e));
    }

    static private List<String> readFromFile(String path){
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;

            while((line = reader.readLine()) != null){
                list.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
