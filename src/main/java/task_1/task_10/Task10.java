package task_1.task_10;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task10 {
    public static void main(String[] args) {
        String path = "text.txt";
        System.out.println(readFromFile(path));
        System.out.println(getIndexOfChar(path, new Scanner(System.in).next().charAt(0)));
        System.out.println(getIndexOfFirstChar(path, new Scanner(System.in).next().charAt(0)));
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

    static private List<Integer> getIndexOfChar(String path, char c){
        String str = readFromFile(path);
        return IntStream.range(0, str.length())
                .filter(e -> str.charAt(e) == c)
                .boxed()
                .toList();
    }

    static private int getIndexOfFirstChar(String path, char c){
        String str = readFromFile(path);
        return IntStream.range(0, str.length())
                .filter(e -> str.charAt(e) == c)
                .findFirst()
                .getAsInt();
    }
}
