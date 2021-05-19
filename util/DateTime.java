package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Utility for creating date & time strings
 */
public class DateTime {
    /**
     * Generate a formatted timestamp at the current time
     * @return Formatted timestamp
     */
    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}
