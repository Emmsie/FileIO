package be.brussel.file_io;

import java.io.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class ByteStream_ZipApp {

    public static void main(String[] args) {

        //deflate text and write it to a file

        try (FileOutputStream fileOutputStream = new FileOutputStream("File.txt");
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(fileOutputStream);
        PrintStream printStream = new PrintStream(deflaterOutputStream, false, "UTF-8")){

            char[] toWrite = "text".toCharArray();
            for ( char character : toWrite){
                printStream.write(character);
            }

            printStream.println("");

            char[] toWrite2 = "more text".toCharArray();
            for ( char character : toWrite2){
                printStream.write(character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        //read text from an inflated file

        try (FileInputStream fileInputStream =  new FileInputStream("File.txt");
        InflaterInputStream inflaterInputStream = new InflaterInputStream(fileInputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(inflaterInputStream, "UTF-8") ){

            int character;
            while((character = inputStreamReader.read()) != -1){
                System.out.print((char)character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
