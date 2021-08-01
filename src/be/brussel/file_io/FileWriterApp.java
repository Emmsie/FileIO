package be.brussel.file_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterApp {

    public static void main(String[] args) {

        File file = new File("File.txt");

        // or use
        // Path path = Paths.get("File.txt");
        // FileWriter file = new FileWriter(path.toFile());

        try(FileWriter fileWriter = new FileWriter(file, true) /*or (File.txt, true)*/){
            fileWriter.write("Hello\n");
            fileWriter.write("World\n");
        } catch (IOException ex){
            System.out.println("Oops! Something wrong");
            System.out.println(ex.getMessage());
        }

    }
}