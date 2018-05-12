package cjxy.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    private static Logger instance = null;

    private Writer bw = null;
    private final Calendar cal = Calendar.getInstance();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy/MM/dd][HH:mm:ss]");

    private Logger() {
        try {
            bw = new FileWriter(new File("log.txt"));
            bw.write("CJXY - Data Exchange Format Converter");
            bw.write(time() + " [Logging Started]");
        } catch(IOException ignored) {}
    }

    public void info(String message) {
        String log = time() + " [" + message + "]" + " [SUCCESSFUL]";
        try {
            bw.write(log);
        } catch(Exception ignored) {}
    }

    public void error(String message) {
        String log = time() + " [" + message + "]" + " [FAILED]";
        try {
            bw.write(log);
        } catch(Exception ignored) {}
    }

    private String time() {
        return dateFormat.format(cal.getTime());
    }

    public static Logger get() {
        if(instance == null)
            instance = new Logger();
        return instance;
    }
}
