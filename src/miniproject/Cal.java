package miniproject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cal {

    public static String getDay(LocalDate ld) {
        String arr[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//        return arr[ld.getDayOfWeek()];
//
        return null;
    }

    //    public static String showYearlyCalendar(int year) {
    public static void showYearlyCalendar(int year) {
//        String resCal = new String();
        for (int month = 0; month < 12; month++) {
            Calendar calendar = new GregorianCalendar(2023, month, 1);// year, month, day of month
            calendar.set(Calendar.DAY_OF_MONTH, 1); //Set the day of month to 1
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); //get day of week for 1st of month
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

//print month name and year

            System.out.println("\n" + new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));
            System.out.println(" S  M  T  W  T  F  S");
//            resCal += ("\n" + new SimpleDateFormat("MMMM YYYY").format(calendar.getTime()));
//            resCal += (" S  M  T  W  T  F  S");

//print initial spaces
            String initialSpace = "";
            for (int i = 0; i < dayOfWeek - 1; i++) {
                initialSpace += "   ";
            }
            System.out.print(initialSpace);
//            resCal += initialSpace;

//print the days of the month starting from 1
            for (int i = 0, dayOfMonth = 1; dayOfMonth <= daysInMonth; i++) {
                for (int j = ((i == 0) ? dayOfWeek - 1 : 0); j < 7 && (dayOfMonth <= daysInMonth); j++) {
                    System.out.printf("%2d ", dayOfMonth);
//                    resCal += dayOfMonth;
                    dayOfMonth++;
                }
                System.out.println();
//                resCal += '\n';
            }
        }

//        return resCal;
    }
}

