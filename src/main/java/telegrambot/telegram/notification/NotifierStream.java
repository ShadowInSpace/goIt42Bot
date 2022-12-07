package telegrambot.telegram.notification;


import telegrambot.telegram.bot.CurrencyTelegramBot;
import telegrambot.user.UserSettings;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.lang.Thread.sleep;

public class NotifierStream {
    UserSettings userSettings = new UserSettings();
    CurrencyTelegramBot bot = new CurrencyTelegramBot();


    public String idler() {

        while (true) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String notificationTime = userSettings.getNotificationTime() + ":00:00";
            if ("16:55:00".equals(dtf.format(now))) {
                System.out.println(userSettings.getChat_id());
            }
            System.out.println(dtf.format(now));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
