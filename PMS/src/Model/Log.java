package Model;

import java.io.*;

// This is a Singleton Log class to record all the events.
public class Log {
    private static Log instance;
    private StringBuilder log;

    private Log() {
        log = new StringBuilder();
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void addEntry(String entry) {
        log.append(entry).append("\n");
    }

    public String getLog() {
        return log.toString();
    }

    public void saveLogToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.err.println("Error writing log to file: " + e.getMessage());
        }
    }
}