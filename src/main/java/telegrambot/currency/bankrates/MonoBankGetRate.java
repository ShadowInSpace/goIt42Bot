package telegrambot.currency.bankrates;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import telegrambot.currency.convertion.MonoBankRate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Set;


public class MonoBankGetRate {



    public List<MonoBankRate> getRate() {
        URI uri;
        try {
            uri = new URI("https://api.monobank.ua/bank/currency");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (response.statusCode() == 200) {

            Gson gson = new Gson();
            List<MonoBankRate> currencies = gson.fromJson(response.body(),
                    new TypeToken<List<MonoBankRate>>() {
                    }
                            .getType());


            return getUnique(currencies);
        }
        return null;
    }

    public List<MonoBankRate> getUnique(List<MonoBankRate> currencies) {

        List<MonoBankRate> availableCurrency = new ArrayList<>();
        Set<Currency> currency = Currency.getAvailableCurrencies();

        for (MonoBankRate m : currencies) {
            String codeA = m.getCurrencyCodeA();
            String codeB = m.getCurrencyCodeB();
            for (Currency c : currency) {
                if (c.getNumericCode() == Integer.parseInt(codeA)) {
                    m.setCurrencyCodeA(c.getCurrencyCode());
                } else if (c.getNumericCode() == Integer.parseInt(codeB)) {
                    m.setCurrencyCodeB(c.getCurrencyCode());
                }
            }
            if (m.getRateBuy() != null & m.getRateSell() != null) {
                availableCurrency.add(m);
            }
        }
        return availableCurrency;
    }
}
