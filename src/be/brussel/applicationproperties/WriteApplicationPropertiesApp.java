package be.brussel.applicationproperties;

import java.io.IOException;

public class WriteApplicationPropertiesApp {

    public static void main(String[] args) {

        ApplicationProperties applicationProperties = new ApplicationProperties("someApplication.properties");

        applicationProperties.setX(5);
        applicationProperties.setY(3);
        applicationProperties.setHeight(7);
        applicationProperties.setWidth(10);

        try {
            applicationProperties.store();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("someApplication.properties has been (over)written with new application properties");

    }
}
