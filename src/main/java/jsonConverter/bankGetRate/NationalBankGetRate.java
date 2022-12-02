package jsonConverter.bankGetRate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import currencyRate.jsonConverter.bankRate.NationalBankCurrency;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class NationalBankGetRate implements GetCurrencyRate {
    @Override
    public String getRate() {
        URI uri;
        try {
            uri = new URI("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
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
            List<NationalBankCurrency> currencies = gson.fromJson(response.body(),
                    new TypeToken<List<NationalBankCurrency>>() {
                    }
                            .getType());


            StringBuilder sb = new StringBuilder();
            sb.append("NBU currency rate \n\n");

            for (NationalBankCurrency m : currencies) {
                if(m.getCc().equals("USD") || m.getCc().equals("EUR"))
                sb.append("UAH").append(" to ").append(m.getCc())
                        .append("\nRate: ").append(m.getRate()).append("\n\n");
            }

            return sb.toString();
        }
        return "Too many requests, try to check you`r internet connection.";
    }

}
