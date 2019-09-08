package contests.contest153;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q2 {
    public static void main(String[] args) throws ParseException {
        System.out.println(dayOfTheWeek(18, 7, 1999));
        System.out.println(dayOfTheWeek(16, 8, 1971));
    }

    public static String dayOfTheWeek(int day, int month, int year) throws ParseException {
        StringBuilder sb = new StringBuilder();

        if(day < 10) {
            sb.append("0" + day + "/");
        } else {
            sb.append(day + "/");
        }

        if(month < 10) {
            sb.append("0" + month + "/");
        } else {
            sb.append(month + "/");
        }

        sb.append(year + "/");

        try {
            String input_date= sb.toString();
            SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
            Date dt1 = format1.parse(input_date);
            DateFormat format2=new SimpleDateFormat("EEEE");
            return format2.format(dt1);
        } catch (Exception ex) {
            return " ";
        }
    }
}