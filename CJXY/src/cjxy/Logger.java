import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {
    private static Logger instance = null;
    private static Calendar cal;

    private Logger(){
        cal = Calendar.getInstance();
    }

    public static Logger getInstance(){
        if(instance == null)
            instance = new Logger();
        return instance;
    }

    public void logInfoWithTime(String info){
        SimpleDateFormat sdf = new SimpleDateFormat("[yyyy.mm.dd, HH:mm:ss]");
        System.out.println(sdf.format(cal.getTime()) + " " + info);
    }
}
