package telegrambot.telegram.keyboard;

import telegrambot.user.UserSettings;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;


import java.util.ArrayList;
import java.util.List;

public class Keyboard {
    public SendMessage mainKeyboard(Long chat_id) {


        //MainKeyBoard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        // Info button
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Отримати інфо");
        button1.setCallbackData("get_rate");


        // Settings button
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Налаштування");
        button2.setCallbackData("get_settings");


        // First line
        rowInline1.add(button1);
        // Second line
        rowInline2.add(button2);

        // Set the keyboard to the markup
        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText("Натисність \"Отримати інфо\" => для відображення курса валют ");
        message.setReplyMarkup(markupInline);

        return message;
    }

    public SendMessage settingsKeyboard(Long chat_id) {

        //Settings keyboard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline5 = new ArrayList<>();

        // Precision button
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("🔍Кількість знаків після коми🔎");
        button3.setCallbackData("get_precision");

        // Bank button
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button4.setText("💰Банк💰");
        button4.setCallbackData("get_bank");


        // Currency button
        InlineKeyboardButton button5 = new InlineKeyboardButton();
        button5.setText("💵 Валюти 💵");
        button5.setCallbackData("get_currency");

        // Notification button
        InlineKeyboardButton button6 = new InlineKeyboardButton();
        button6.setText("⏱Час оповіщення⏱");
        button6.setCallbackData("get_notification");

        // Main keybord
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("🔙 Назад");
        button.setCallbackData("/start");

        // First line
        rowInline1.add(button3);
        // Second line
        rowInline2.add(button4);
        // Fourth line
        rowInline3.add(button5);
        // Fifth line
        rowInline4.add(button6);

        rowInline5.add(button);

        // Set the keyboard to the markup
        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);
        rowsInline.add(rowInline4);
        rowsInline.add(rowInline5);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText("Налаштування");

        message.setReplyMarkup(markupInline);

        return message;
    }

    public SendMessage precisionKeyboard(Long chat_id, UserSettings userSettings) {
        String check_mark = "✅";

        //Settings precision keyboard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

        // -2 button
        InlineKeyboardButton button7 = new InlineKeyboardButton();
        button7.setText("2");
        button7.setCallbackData("2");

        // -3 button
        InlineKeyboardButton button8 = new InlineKeyboardButton();
        button8.setText("3");
        button8.setCallbackData("3");


        // -4 button
        InlineKeyboardButton button9 = new InlineKeyboardButton();
        button9.setText("4");
        button9.setCallbackData("4");

        switch (userSettings.getPrecession()) {
            case "2":
                button7.setText(check_mark + " 2");
                break;
            case "3":
                button8.setText(check_mark + " 3");
                break;
            case "4":
                button9.setText(check_mark + " 4");
                break;
        }

        rowInline1.add(button7);
        rowInline2.add(button8);
        rowInline3.add(button9);

        // Set the keyboard to the markup
        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        // Forming message to send
        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText("Кількість знаків після коми");
        message.setReplyMarkup(markupInline);

        return message;
    }

    public SendMessage bankKeyboard(Long chat_id, UserSettings userSettings) {
        String check_mark = "✅";

        //Settings bank keyboard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

        // PrivatBank button
        InlineKeyboardButton button10 = new InlineKeyboardButton();
        button10.setText("ПриватБанк");
        button10.setCallbackData("privat");

        // NBU button
        InlineKeyboardButton button11 = new InlineKeyboardButton();
        button11.setText("НБУ");
        button11.setCallbackData("nbu");


        // MonoBank button
        InlineKeyboardButton button12 = new InlineKeyboardButton();
        button12.setText("МоноБанк");
        button12.setCallbackData("monobank");

        switch (userSettings.getBank()) {
            case "Privat":
                button10.setText(check_mark + " ПриватБанк");
                break;
            case "NBU":
                button11.setText(check_mark + " НБУ");
                break;
            case "Mono":
                button12.setText(check_mark + " МоноБанк");
                break;
        }

        rowInline1.add(button10);
        rowInline2.add(button11);
        rowInline3.add(button12);

        // Set the keyboard to the markup
        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);


        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        // Forming message to send
        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText("Банк");
        message.setReplyMarkup(markupInline);
        return message;
    }

    public SendMessage currencyKeyboard(Long chat_id, UserSettings userSettings) {
        String check_mark = "✅";
        //Settings bank keyboard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();

        // USD button
        InlineKeyboardButton button0 = new InlineKeyboardButton();
        button0.setText("USD");
        button0.setCallbackData("usd");

        // EUR button
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("EUR");
        button1.setCallbackData("eur");

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("🔙 Назад");
        button3.setCallbackData("get_settings");


        if (userSettings.getCurrency()[0].equals("USD")) {
            button0.setText(check_mark + " USD");
        }
        if(userSettings.getCurrency()[1].equals("EUR")) {
            button1.setText(check_mark + "EUR");
        }



        rowInline1.add(button0);
        rowInline2.add(button1);
        rowInline3.add(button3);


        // Set the keyboard to the markup
        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);

        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        // Forming message to send
        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText("Валюта");
        message.setReplyMarkup(markupInline);
        return message;
    }

    public SendMessage notificationKeyboard(Long chat_id, UserSettings userSettings) {
        String check_mark = "✅";

        //Settings bank keyboard
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();

        InlineKeyboardButton button14 = new InlineKeyboardButton();
        button14.setCallbackData("9");
        button14.setText("9");
        InlineKeyboardButton button15 = new InlineKeyboardButton();
        button15.setCallbackData("10");
        button15.setText("10");
        InlineKeyboardButton button16 = new InlineKeyboardButton();
        button16.setCallbackData("11");
        button16.setText("11");

        InlineKeyboardButton button17 = new InlineKeyboardButton();
        button17.setCallbackData("12");
        button17.setText("12");
        InlineKeyboardButton button18 = new InlineKeyboardButton();
        button18.setCallbackData("13");
        button18.setText("13");
        InlineKeyboardButton button19 = new InlineKeyboardButton();
        button19.setCallbackData("14");
        button19.setText("14");

        InlineKeyboardButton button20 = new InlineKeyboardButton();
        button20.setCallbackData("15");
        button20.setText("15");
        InlineKeyboardButton button21 = new InlineKeyboardButton();
        button21.setCallbackData("16");
        button21.setText("16");
        InlineKeyboardButton button22 = new InlineKeyboardButton();
        button22.setCallbackData("17");
        button22.setText("17");


        InlineKeyboardButton button23 = new InlineKeyboardButton();
        button23.setCallbackData("18");
        button23.setText("18");
        InlineKeyboardButton button24 = new InlineKeyboardButton();
        button24.setText("Вимкнуто");
        button24.setCallbackData("off");


        switch (userSettings.getNotificationTime()) {
            case "9":
                button14.setText(check_mark + "9");
                break;
            case "10":
                button15.setText(check_mark + "10");
                break;
            case "11":
                button16.setText(check_mark + "11");
                break;
            case "12":
                button17.setText(check_mark + "12");
                break;
            case "13":
                button18.setText(check_mark + "13");
                break;
            case "14":
                button19.setText(check_mark + "14");
                break;
            case "15":
                button20.setText(check_mark + "15");
                break;
            case "16":
                button21.setText(check_mark + "16");
                break;
            case "17":
                button22.setText(check_mark + "17");
                break;
            case "18":
                button23.setText(check_mark + "18");
                break;
            case "off":
                button24.setText(check_mark + "Вимкнуто");
                break;
        }

        rowInline1.add(button14);
        rowInline1.add(button15);
        rowInline1.add(button16);
        rowInline2.add(button17);
        rowInline2.add(button18);
        rowInline2.add(button19);
        rowInline3.add(button20);
        rowInline3.add(button21);
        rowInline3.add(button22);
        rowInline4.add(button23);
        rowInline4.add(button24);


        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);
        rowsInline.add(rowInline4);


        // Add it to the message
        markupInline.setKeyboard(rowsInline);

        // Forming message to send
        SendMessage message = new SendMessage();
        message.setChatId(chat_id);
        message.setText("Час оповіщення");
        message.setReplyMarkup(markupInline);

        return message;
    }
}
