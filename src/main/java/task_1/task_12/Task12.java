package task_1.task_12;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Task12 {
    public static void main(String[] args) {
        String path = "text.txt";
        String str = readFromFile(path);
        System.out.println(readFromFile(path));
        System.out.println("------------------------------------");
        System.out.println(reverseString(str));
        System.out.println("------------------------------------");
        System.out.println(reverseStringWithoutPunctuationMarks(str));
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
        return sb.toString();
    }

    static private String reverseString(String str){
        String[] arrayStr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, arrayStr.length)
                .mapToObj(i -> arrayStr[arrayStr.length - i])
                .toList()
                .forEach(e -> {
                    sb.append(e + " ");
                });
        return sb.toString();
    }

    static private String reverseStringWithoutPunctuationMarks(String str){
        String[] arrayStr = str.split("\\P{L}");
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, arrayStr.length)
                .mapToObj(i -> arrayStr[arrayStr.length - i])
                .toList()
                .forEach(e -> {
                    sb.append(e + " ");
                });
        return sb.toString();
    }
}
