package telegrambot.telegram.notification;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import telegrambot.controller.Controller;
import telegrambot.user.UserSettings;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.lang.Thread.sleep;

public class NotifierStream {

    @SneakyThrows
    public String idler(UserSettings userSettings, CallbackQuery callbackQuery) {
        Long chat_id = callbackQuery.getMessage().getChatId();
        while (true){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String notificationTime = userSettings.getNotificationTime() + ":00:00";
            if ("23:30:00".equals(dtf.format(now))){
//                SendMessage message = new SendMessage();
//                message.setChatId(chat_id);
//               new Controller(userSettings).resultMessage();
//               execute(message)
            }
            System.out.println(dtf.format(now));
            sleep(1000);
        }
    }
}
