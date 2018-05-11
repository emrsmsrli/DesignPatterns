package cjxy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    private static Logger instance = null;
    private static Calendar cal;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("[yyyy.MM.dd, HH:mm:ss]");

    private Logger() {
        cal = Calendar.getInstance();
    }

    public static Logger getInstance() {
        if(instance == null)
            instance = new Logger();
        return instance;
    }

    public void logInfoWithTime(String info) {
        String log = dateFormat.format(cal.getTime()) + " [" + info + "]" + " [SUCCESSFUL]";
        System.out.println(log);
    }

    public void logErrorWithTime(String info) {
        String log = dateFormat.format(cal.getTime()) + " [" + info + "]" + " [FAILED]";
        System.out.println(log);
    }
}
