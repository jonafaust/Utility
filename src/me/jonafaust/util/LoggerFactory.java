package me.jonafaust.util;

public class LoggerFactory {

    private boolean fileLogging = false;
    private boolean networkLogging = false;

    public void setFileLogging(boolean fileLogging) {
        this.fileLogging = fileLogging;
    }

    public void setNetworkLogging(boolean networkLogging) {
        this.networkLogging = networkLogging;
    }

    public boolean isFileLogging() {
        return fileLogging;
    }

    public boolean isNetworkLogging() {
        return networkLogging;
    }

    public Logger buildLogger() {
        return new Logger(this);
    }
}
