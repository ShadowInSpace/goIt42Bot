package telegrambot.telegram.bot;

import telegrambot.controller.Controller;
import telegrambot.telegram.keyboard.Keyboard;
import telegrambot.user.UserSettings;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URISyntaxException;


public class CurrencyTelegramBot extends TelegramLongPollingBot {
    private final UserSettings userSettingsState = new UserSettings();
    private final Controller controller = new Controller();
    public String getBotUsername() {
        return "try_to_not_find_bot";
    }
    public String getBotToken() {
        return "5940494263:AAGtrZMoFoZjIH5ZPI4_ZPRhT2RvUNC9nJY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();

            if (update.getMessage().getText().equals("/start")) {
                // Create a message  object
                SendMessage message;
                message = new Keyboard().mainKeyboard(chat_id);
                userSettingsState.setChat_id(chat_id);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

        } else if (update.hasCallbackQuery()) {
            try {
                handleCallback(update.getCallbackQuery());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        System.out.println(update.getMessage().getDate().longValue());

    }

    private void handleCallback(CallbackQuery callbackQuery) throws TelegramApiException {
        long chat_id = callbackQuery.getMessage().getChatId();
        String call_data = callbackQuery.getData();
        SendMessage message = new SendMessage();

        switch (call_data) {
            case "/start":
                message = new Keyboard().mainKeyboard(chat_id);
                execute(message); // Sending our message object to user
                break;

            case "get_rate":
                message.setChatId(chat_id);
                try {
                    message.setText(controller.resultMessage());
                } catch (IOException | InterruptedException | URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                execute(message);
                message = new Keyboard().mainKeyboard(chat_id);
                execute(message); // Sending our message object to user
                break;

            case "get_settings":
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;

            case "get_precision":
                message = new Keyboard().precisionKeyboard(chat_id, userSettingsState);
                execute(message);
                break;

            case "2":
                userSettingsState.setPrecession("2");
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;

            case "3":
                userSettingsState.setPrecession("3");
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;

            case "4":
                userSettingsState.setPrecession("4");
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;

            case "get_bank":
                message = new Keyboard().bankKeyboard(chat_id, userSettingsState);
                execute(message);
                break;

            case "privat":
                userSettingsState.setBank("Privat");
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;

            case "nbu":
                userSettingsState.setBank("NBU");
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;

            case "monobank":
                userSettingsState.setBank("Mono");
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;

            case "get_currency":
                message = new Keyboard().currencyKeyboard(chat_id, userSettingsState);
                execute(message);
                break;

            case "usd":
                if (userSettingsState.getCurrency()[0].equals("USD")) {
                    userSettingsState.setCurrency0("null");
                } else {
                    userSettingsState.setCurrency0("USD");
                }
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;
            case "eur":
                if (userSettingsState.getCurrency()[1].equals("EUR")) {
                    userSettingsState.setCurrency1("null");
                } else {
                    userSettingsState.setCurrency1("EUR");
                }
                message = new Keyboard().settingsKeyboard(chat_id);
                execute(message);
                break;

            case "get_notification":
                message = new Keyboard().notificationKeyboard(chat_id, userSettingsState);
                execute(message);
                break;
            default:
                notificationTime(callbackQuery);
                break;
        }
    }

    private void notificationTime(CallbackQuery callbackQuery) throws TelegramApiException {
        long chat_id = callbackQuery.getMessage().getChatId();
        String call_data = callbackQuery.getData();
        SendMessage message = new Keyboard().settingsKeyboard(chat_id);

        switch (call_data) {
            case "9":
                userSettingsState.setNotificationTime("9");
                execute(message);
                break;
            case "10":
                userSettingsState.setNotificationTime("10");
                execute(message);
                break;
            case "11":
                userSettingsState.setNotificationTime("11");
                execute(message);
                break;
            case "12":
                userSettingsState.setNotificationTime("12");
                execute(message);
                break;
            case "13":
                userSettingsState.setNotificationTime("13");
                execute(message);
                break;
            case "14":
                userSettingsState.setNotificationTime("14");
                execute(message);
                break;
            case "15":
                userSettingsState.setNotificationTime("15");
                execute(message);
                break;
            case "16":
                userSettingsState.setNotificationTime("16");
                execute(message);
                break;
            case "17":
                userSettingsState.setNotificationTime("17");
                execute(message);
                break;
            case "18":
                userSettingsState.setNotificationTime("18");
                execute(message);
                break;
            case "off":
                userSettingsState.setNotificationTime("off");
                execute(message);
                break;
            default:
        }
    }

    public void notifyer() {
        SendMessage message;
        message = new Keyboard().mainKeyboard(userSettingsState.getChat_id());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
