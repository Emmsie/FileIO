package be.brussel.file_io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedWriter_ReaderApp {

    public static void main(String[] args) {

//        Path path = Paths.get("File.txt");

        try(BufferedReader reader =  new BufferedReader(new FileReader("File.txt")) /* or = Files.newBufferedReader(path)*/) {
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ex){
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
        }



        try(BufferedWriter writer = new BufferedWriter(new FileWriter("File.txt", true))){
            writer.write("Hello Hello");
            writer.newLine();
            writer.write("Worlds");
            writer.newLine();
        } catch (IOException ex){
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
        }
    }
}