package jsonConverter.bankGetRate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jsonConverter.bankRate.PrivateBankCurrency;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PrivateBankGetRate implements GetCurrencyRate {

    @Override
    public String getRate() {
        URI uri;
        try {
            uri = new URI("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5");
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
            List<PrivateBankCurrency> currencies = gson.fromJson(response.body(),
                    new TypeToken<List<PrivateBankCurrency>>() {
                    }
                            .getType());

            StringBuilder sb = new StringBuilder();

            sb.append("PrivateBank currency rate \n");
            for (PrivateBankCurrency o : currencies) {
                sb.append("\n").append(o.getBaseCurrency()).append(" to ").append(o.getCurrency()).append("\n");
                sb.append("Buy: ").append(o.getBuy()).append("\n").append("Sell: ").append(o.getSale()).append("\n");
            }

            return sb.toString();
        }
        return "Try to check you`r internet connection";
    }
}
