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


The utility package has its own logger. 
To instantiate the logger you need the LoggerFactory, shown in this example:

```java
import me.jonafaust.util.Logger;
import me.jonafaust.util.LoggerFactory;

public class Main {
    public static void main(String[] args) {

        //Create the LoggerFactory
        LoggerFactory loggerFactory = new LoggerFactory();

        //Enable logging to a file. 
        loggerFactory.setFileLogging(true);

        //Disable Network Logging (Not implemented yet)
        loggerFactory.setNetworkLogging(false);

        //Build the Logger 
        Logger logger = loggerFactory.buildLogger();
        
        
        //Different log options
        logger.log("Hello World");
        logger.debug("Hello Developer");
        logger.success("success");
        logger.warn("Warning");
        logger.error("An error occurred while performing a hello world application");
    }
}

```