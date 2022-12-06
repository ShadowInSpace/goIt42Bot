package telegrambot.telegram.notification;

import telegrambot.user.UserSettings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotifierStream {

    public void idler(UserSettings userSettings) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    public static void main(String[] args) {


    }
}
