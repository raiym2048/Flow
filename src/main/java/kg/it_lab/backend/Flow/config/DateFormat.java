package kg.it_lab.backend.Flow.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

final public class DateFormat {

    public static LocalDateTime dateFormatУMD(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(str, formatter);
    }

    public static LocalDateTime dateFormatDMY(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return LocalDateTime.parse(str, formatter);
    }
}
