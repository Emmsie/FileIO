package be.brussel.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class Person implements Serializable {

    private static final long serialVersionUID = -3639605977385884127L;

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private transient Timer heartbeat;

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        heartbeat = new Timer(true);
        heartbeat.scheduleAtFixedRate(new Heartbeat(), 0, 1000);
    }

    private class Heartbeat extends TimerTask {
        public void run(){
            System.out.print("* ");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", heartbeat=" + heartbeat.getClass()  +
                '}';
    }

//    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
//        objectOutputStream.defaultWriteObject();
//    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        heartbeat = new Timer(true);
        heartbeat.scheduleAtFixedRate(new Heartbeat(), 0, 1000);
    }
}
