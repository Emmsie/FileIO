package be.brussel.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CivilServiceApp {

    public static void main(String[] args) {

        try(FileInputStream fileInputStream = new FileInputStream("Will_Turner.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            Person willTurner = (Person) objectInputStream.readObject();
            System.out.println(willTurner);


        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
