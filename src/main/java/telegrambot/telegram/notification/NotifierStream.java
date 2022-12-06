package telegrambot.telegram.notification;

import lombok.SneakyThrows;
import telegrambot.user.UserSettings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.lang.Thread.sleep;

public class NotifierStream {

    @SneakyThrows
    public String idler(UserSettings userSettings) {
        while (true){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String notificationTime = userSettings.getNotificationTime() + ":00:00";
            if (notificationTime.equals(dtf.format(now))){
                return "notify";
            }
            sleep(1000);
        }
    }
}