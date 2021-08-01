package be.brussel.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;


public class MaternityApp {

    public static void main(String[] args) {

        Person willTurner = new Person("Will", "Turner", LocalDate.of(1700, 8, 30));

        try (FileOutputStream fileOutputStream = new FileOutputStream(willTurner.getFirstName()+ "_"+ willTurner.getLastName()+".txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(willTurner);


        } catch (IOException e) {
            e.printStackTrace();
        }

        // prevent program from ending
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
