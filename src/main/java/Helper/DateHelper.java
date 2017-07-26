package Helper;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by p on 2017/7/22.
 */
public class DateHelper {
    public static Date getExpiredDate(int day){
        return new Date(new java.util.Date().getTime() + day * 24 * 60 * 60 * 1000);
    }

    public static boolean isExpired(Date date){
        Calendar calendar = Calendar.getInstance();
        java.util.Date utilDate = calendar.getTime();
        //java.util.Date日期转换成转成java.sql.Date格式
        Date nowDate = new Date(utilDate.getTime());
        return nowDate.after(date);
    }
}
