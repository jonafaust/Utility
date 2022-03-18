# Utility

This repository contains frequently used functions for various projects. 

In the moment are included: 
- ConfigReader
- Logger

The config reader can be instantiated via following lines:

````java
public class Main {
    public static void main(String[] args) {
        
        // With default config
        ConfigReader cnf = new ConfigReader();
        
        // With custom config
        String configText = 
        """
        name1 = value1
        name2 = value2        
        """;
        ConfigReader cnf = new ConfigReader(configText);
    }
}
````

To get a property from the config:

````java
public class Main {
    public static void main(String[] args) {
        ConfigReader cnf = new ConfigReader();
        
        String token;
        token = cnf.getProperty("app.token");
    }
}
````