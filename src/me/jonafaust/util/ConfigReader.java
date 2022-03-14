package me.jonafaust.util;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    private String config =
            """
            db.url = 
            db.username = 
            db.password = 
            
            app.token = 
            """;

    private Properties properties;

    public ConfigReader() throws IOException {
        File file = new File("config.properties");
        if(!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(this.config);
            writer.close();
            System.out.println("The config.properties file has been created. The system will now exit so that the file can be configured. ");
            System.exit(1);
        }
        this.properties = new Properties();
        this.properties.load(new FileInputStream(file));
    }

    public ConfigReader(String config) throws IOException {
        File file = new File("config.properties");
        if(!file.exists()) {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(config);
            writer.close();
            System.out.println("The config.properties file has been created. The system will now exit so that the file can be configured. ");
            System.exit(1);
        }
        this.properties = new Properties();
        this.properties.load(new FileInputStream(file));
    }

    public String getProperty(String property) {
        return this.properties.getProperty(property);
    }
}
