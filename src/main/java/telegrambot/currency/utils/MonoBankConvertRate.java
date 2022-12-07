package telegrambot.currency.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import telegrambot.currency.model.Currency;
import telegrambot.currency.model.MonoBankRate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class MonoBankConvertRate extends ConvertRate {

    public void convertResponseToCurrency(List<Currency> listCurrencies)
            throws InterruptedException, IOException, URISyntaxException {
        JsonArray jsonArray = responseToJsonArray
                ("https://api.monobank.ua/bank/currency");
        int count = 0;
        while (count < jsonArray.size() - 1) {
            JsonObject jsonObject = jsonArray.get(count++).getAsJsonObject();
            MonoBankRate mono = createMonoBankRateFromJson(jsonObject);
            if (mono.getCurrencyCodeA() == Currency.getCURRENCY_CODE_USD()
                    && mono.getCurrencyCodeB() == Currency.getCURRENCY_CODE_UHN()) {
                listCurrencies.add(setCurrency(mono, "USD"));
            } else if (mono.getCurrencyCodeA() == Currency.getCURRENCY_CODE_EUR()
                    && mono.getCurrencyCodeB() == Currency.getCURRENCY_CODE_UHN()) {
                listCurrencies.add(setCurrency(mono, "EUR"));
                return;
            }
        }
    }


    protected static Currency setCurrency(MonoBankRate bank, String currencyName) {
        Currency currency = new Currency();
        currency.setBuy(bank.getBuy());
        currency.setSell(bank.getSell());
        currency.setCurrencyName(currencyName);
        currency.setBankName("Mono");
        return currency;
    }

    private static MonoBankRate createMonoBankRateFromJson(JsonObject jsonObject) {
        MonoBankRate mono = new MonoBankRate();
        mono.setCurrencyCodeA(jsonObject.get("currencyCodeA").getAsInt());
        mono.setCurrencyCodeB(jsonObject.get("currencyCodeB").getAsInt());
        mono.setDate(jsonObject.get("date").getAsInt());
        mono.setBuy(jsonObject.get("rateBuy").getAsBigDecimal());
        mono.setSell(jsonObject.get("rateSell").getAsBigDecimal());

        return mono;
    }

}
