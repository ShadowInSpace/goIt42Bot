package telegrambot.controller;

import org.telegram.telegrambots.meta.api.objects.User;
import telegrambot.user.UserSettings;

import java.util.List;

public class Controller {
    private static final String eurSell = "41.09876";
    private static final String eurBuy = "40.509873";
    private static final String usdSell = "38.509873";
    private static final String usdBuy = "37.09876";

    private static final List<String> rate = List.of(new String[]{eurSell, eurBuy, usdSell, usdBuy});

    private static final String ERROR_MESSAGE = "Unknown command, write BUY or SELL";
    private static final String PRIVAT = "Privat";
    private static final String MONO = "Mono";
    private static final String NBU = "NBU";
    private static final String CURRENCY0 = "USD";
    private static final String CURRENCY1 = "EUR";

    UserSettings settings ;

    public Controller(UserSettings userSettings){
        this.settings = userSettings;
    }
    public String resultMessage() {
        String [] currency = settings.getCurrency();
        String response = "Курс валют в ";
        switch (settings.getBank()) {
            case PRIVAT:
                response += "Приватбанк";
                break;
            case MONO:
                response += "Монобанк";
                break;
            case NBU:
                response += "НБУ";
                break;
            default:
                response = "Виберіть будь ласка валюту";
                return response;
        }
        if (CURRENCY0.equals(currency[0])) {
            String MESSAGE_USD = "\nUSD/UAH\n" + "Покупка: " + roundedRate(usdBuy)
                    + "\nПродажа: " + roundedRate(usdSell);
            response += MESSAGE_USD;
        }
        if (CURRENCY1.equals(currency[1])) {
            String MESSAGE_EUR = "\nEUR/UAH\n" + "Покупка: " + roundedRate(eurBuy)
                    + "\nПродажа: " + roundedRate(eurSell);
            response += MESSAGE_EUR;
        }
        return response;
    }
    private String roundedRate(String rate){
        return String.format("%." + settings.getPrecession() + "f", Double.parseDouble(rate));
    }
}