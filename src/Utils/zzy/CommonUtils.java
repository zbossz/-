package Utils.zzy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    public static String getNowTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}
