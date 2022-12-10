package telegrambot.controller;

import telegrambot.user.UserSettings;
import telegrambot.currency.model.Currency;
import telegrambot.currency.utils.ConvertRate;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;

public class Controller {
    private static final String PRIVATE = "Privat";
    private static final String MONO = "Mono";
    private static final String NBU = "NBU";
    UserSettings settings = new UserSettings();
    String[] currencyName = settings.getCurrency();


    public String resultMessage() throws IOException, URISyntaxException, InterruptedException {
        StringBuilder response = new StringBuilder("Курс валют в " + changeNameBank());
        for (Currency dataBankRate : ConvertRate.allCurrencyToList()) {
            if (settings.getBank().equals(dataBankRate.getBankName())) {
                if (dataBankRate.getCurrencyName().equals(currencyName[0])) {
                    response.append("\nUSD/UAH\n" + "Покупка: ").append(roundedRate(dataBankRate.getBuy())).append("\nПродажа: ").append(roundedRate(dataBankRate.getSell()));
                }
                if (dataBankRate.getCurrencyName().equals(currencyName[1])) {
                    response.append("\nEUR/UAH\n" + "Покупка: ").append(roundedRate(dataBankRate.getBuy())).append("\nПродажа: ").append(roundedRate(dataBankRate.getSell()));
                }
            }
            if (currencyName[0].equals(currencyName[1])) {
                response = new StringBuilder("Виберіть будь ласка валюту");
            }
        }
        return response.toString();
    }

    private String changeNameBank() {
        String resultNameBank = null;
        switch (settings.getBank()) {
            case PRIVATE:
                resultNameBank = "Приватбанк";
                break;
            case MONO:
                resultNameBank = "Монобанк";
                break;
            case NBU:
                resultNameBank = "НБУ";
                break;
        }
        return resultNameBank;
    }

    private String roundedRate(BigDecimal rate) {
        String roundedRate;
        if (!(rate == null)) {
            roundedRate = String.format("%." + settings.getPrecession() + "f", rate);
        } else {
            roundedRate = "Дана операція не проводиться";
        }
        return roundedRate;
    }
}
