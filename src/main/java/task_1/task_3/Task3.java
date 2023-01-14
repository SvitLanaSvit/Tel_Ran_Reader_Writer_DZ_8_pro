package task_1.task_3;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        String path = "text.txt";
        String str = readFromFile(path);
        long start1 = System.nanoTime();
        System.out.println(readFromFile(path));
        System.out.println("Time for reading from file with char: " + (System.nanoTime() - start1));
        long lowerCharsCount = str.chars()
                .filter(e -> Character.isLetter(e))
                .filter(c -> c - Character.toLowerCase(c) == 0)
                .count();
        long upperCharsCount = str.chars()
                .filter(e -> Character.isLetter(e))
                .filter(c -> c - Character.toUpperCase(c) == 0)
                .count();
        System.out.println("Count of lower chars = " + lowerCharsCount);
        System.out.println("Count of upper chars = " + upperCharsCount);
        System.out.println("-------------------------------------------");

        long start2 = System.nanoTime();
        String strBufferReader = readFromFileWithBufferReader(path);
        System.out.println("Time for reading from file with line: " + (System.nanoTime() - start2));
        long lowerCharsCountBuffer = strBufferReader.chars()
                .filter(e -> Character.isLetter(e))
                .filter(c -> c - Character.toLowerCase(c) == 0)
                .count();
        long upperCharsCountBuffer = strBufferReader.chars()
                .filter(e -> Character.isLetter(e))
                .filter(c -> c - Character.toUpperCase(c) == 0)
                .count();
        System.out.println("Count of lower chars = " + lowerCharsCountBuffer);
        System.out.println("Count of upper chars = " + upperCharsCountBuffer);
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

    static private String readFromFileWithBufferReader(String path){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
        }catch (IOException ex){
            throw  new RuntimeException(ex);
        }
        return sb.toString();
    }
}
