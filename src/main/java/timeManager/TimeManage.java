package timeManager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeManage {
    public static String getTimeStamp(){
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    public static  String simpleTimeStamp(){
        return Long.toString(System.currentTimeMillis());
    }
}
