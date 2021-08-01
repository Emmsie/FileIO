package be.brussel.applicationproperties;

import java.io.IOException;

public class ReadApplicationPropertiesApp {

    public static void main(String[] args) {

        ApplicationProperties applicationProperties = new ApplicationProperties("someApplication.properties");

        try {
            applicationProperties.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
