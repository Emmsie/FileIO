package be.brussel.applicationproperties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {

    private Properties properties;
    private String fileName;

    public ApplicationProperties(String fileName) {
        this.fileName = fileName;
        properties = new Properties();
    }

    public int getX(){
        return Integer.parseInt(properties.getProperty("x"));
    }

    public int getY(){
        return Integer.parseInt(properties.getProperty("y"));
    }

    public int getHeight(){
        return Integer.parseInt(properties.getProperty("h"));
    }

    public int getWidth(){
        return Integer.parseInt(properties.getProperty("w"));
    }

    public void setX(int x){
        properties.setProperty("x", String.valueOf(x));
    }

    public void setY(int y){
        properties.setProperty("y", String.valueOf(y));
    }

    public void setHeight(int h){
        properties.setProperty("h", String.valueOf(h));
    }

    public void setWidth(int w){
        properties.setProperty("w", String.valueOf(w));
    }

    public void load() throws IOException {
        try(FileInputStream inputStream = new FileInputStream(fileName)){
            properties.load(inputStream);
            properties.list(System.out);
        }
    }

    public void store() throws IOException {
        try(FileOutputStream outputStream = new FileOutputStream(fileName)){
            properties.store(outputStream, "Application Properties");
        }
    }


}
