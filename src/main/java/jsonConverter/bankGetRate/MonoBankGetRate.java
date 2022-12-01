package jsonConverter.bankGetRate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import currencyRate.jsonConverter.bankRate.MonoBankCurrency;

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


public class MonoBankGetRate implements GetCurrencyRate {


    @Override
    public String getRate() {
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
            List<currencyRate.jsonConverter.bankRate.MonoBankCurrency> currencies = gson.fromJson(response.body(),
                    new TypeToken<List<currencyRate.jsonConverter.bankRate.MonoBankCurrency>>() {
                    }
                            .getType());


            List<MonoBankCurrency> mono = getUnique(currencies);
            StringBuilder sb = new StringBuilder();
            sb.append("MonoBank currency rate \n\n");

            for (MonoBankCurrency m : mono) {
                sb.append(m.getCurrencyCodeB()).append(" to ").append(m.getCurrencyCodeA())
                        .append("\nSell: ").append(m.getRateSell()).append("\n")
                        .append("Buy: ").append(m.getRateBuy()).append("\n\n");
            }

            return sb.toString();
        }
        return "Too many requests, they limited by MonoBank.";
    }

    public List<MonoBankCurrency> getUnique(List<MonoBankCurrency> currencies) {

        List<MonoBankCurrency> availableCurrency = new ArrayList<>();
        Set<Currency> currency = Currency.getAvailableCurrencies();

        for (MonoBankCurrency m : currencies) {
            String codeA = m.getCurrencyCodeA();
            String codeB = m.getCurrencyCodeB();
            for (Currency c : currency) {
                if (c.getNumericCode() == Integer.parseInt(codeA)) {
                    m.setCurrencyCodeA(c.getCurrencyCode());
                } else if (c.getNumericCode() == Integer.parseInt(codeB)) {
                    m.setCurrencyCodeB(c.getCurrencyCode());
                }
            }
            if (m.getRateBuy() != null & m.getRateSell() != null ) {
                availableCurrency.add(m);
            }
        }
        return availableCurrency;
    }
}
