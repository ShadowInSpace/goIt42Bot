package telegrambot.telegram.notification;

import telegrambot.currency.model.Currency;
import telegrambot.telegram.bot.CurrencyTelegramBot;
import telegrambot.user.UserSettings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Thread.sleep;

public class NotifierStream implements Runnable {
    UserSettings userSettings = new UserSettings();
    CurrencyTelegramBot currency = new CurrencyTelegramBot();

    public void idler(UserSettings userSettings) {
        while (true) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String notificationTime = userSettings.getNotificationTime() + ":00:00";
            if (notificationTime.equals(dtf.format(now))) {
                currency.notifier();
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void run() {
        idler(userSettings);
    }
}
