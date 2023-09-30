package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String converter(LocalDateTime date, String formatDate) {
        if(date == null) {
            return "";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatDate);
            return date.format(formatter);
        }
    }
}
