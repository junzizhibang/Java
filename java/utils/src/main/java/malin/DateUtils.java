package malin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils   {
    static SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");

    /**
     *@功能描述  主要是获取今天日期
     *@作者      马琳-脚踏实地积累。2019/6/13 17:35
     *@email    1217575485@qq.com
     */
    public   static String  getToday(){

        Date date=new Date();
        return  sdf.format(date);
    }
    /**
     *@功能描述  获取给定日期的昨天日期
     *@作者      马琳-脚踏实地积累。2019/6/13 17:36
     *@email    1217575485@qq.com
     */
    public   static String  getYesterday(String  today){
        Calendar  calendar=Calendar.getInstance();
        Date  date=new Date();
        try{
            date=   sdf.parse(today);
        }catch (Exception ex){
          ex.printStackTrace();
        }
        calendar.setTime(date );
        calendar.add(Calendar.DATE,-1);
        return  sdf.format(calendar.getTime());
    }
    /**
     *@功能描述  获取当前日期的昨天日期
     *@作者      马琳-脚踏实地积累。2019/6/13 17:41
     *@email    1217575485@qq.com
     */
    public   static   String  getNewYeaterDay(){
        Calendar  calendar =Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        String  yesterday=sdf.format(calendar.getTime());
        return yesterday;
    }

    public static void main(String[] args) {

        String  today=getToday();
        String yesterday=getYesterday(today);
        String newYesterday=getNewYeaterDay();
        System.out.println("今天日期"+today+"昨天日期" + yesterday +"昨天"+ newYesterday );
//        今天日期2019-06-13昨天日期2019-06-12昨天2019-06-12
    }
}
