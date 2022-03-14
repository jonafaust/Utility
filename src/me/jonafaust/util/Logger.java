package me.jonafaust.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private boolean fileLogging = false;
    private boolean networkLogging = false;
    File file;

    private Logger() {

    }

    public Logger(LoggerFactory factory) {
        fileLogging = factory.isFileLogging();
        networkLogging = factory.isNetworkLogging();
        if(fileLogging) {
            this.file = new File("logs/log.txt");
            try {
                Files.createDirectories(Paths.get("logs"));
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
            } catch (IOException e) {
                log("occurred while creating the log.txt file: " + e.getMessage());
            }
        }
    }

    private void out(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("[dd:MM - kk:mm:ss] | ");
        Date currentDate = new Date(System.currentTimeMillis());
        System.out.println(sdf.format(currentDate) + msg);
    }

    private void logToFile(String logText) {
        if(fileLogging) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("[dd:MM - kk:mm:ss] | ");
                Date currentDate = new Date(System.currentTimeMillis());
                logText = sdf.format(currentDate) + logText+ "\n";
                Files.write(Paths.get("logs/log.txt"), logText.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ignored) {}
        }
    }

    public void log(String msg) {
        out("[log] " + msg);
        logToFile("[log] " + msg);
    }

    public void warn(String msg) {
        out(ANSI_YELLOW + "[warn] " + ANSI_RESET + msg);
        logToFile("[warn] " + msg);
    }

    public void error(String msg) {
        out(ANSI_RED + "[error] " + msg + ANSI_RESET);
        logToFile("[error] " + msg);
    }

    public void debug(String msg) {
        out(ANSI_CYAN + "[debug] " + ANSI_RESET + msg);
        logToFile("[debug] " + msg);
    }

    public void success(String msg) {
        out(ANSI_GREEN + "[success] " + ANSI_RESET + msg);
        logToFile("[success] " + msg);
    }
}
