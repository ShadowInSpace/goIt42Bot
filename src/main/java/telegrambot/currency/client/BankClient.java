package telegrambot.currency.client;

import telegrambot.user.UserSettings;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BankClient {
    private static String bufferDatePb = "";
    private static String bufferDateMb = "";
    private static String bufferDateNBU = "";
    UserSettings settings = new UserSettings();

    private final static HttpClient client = HttpClient.newHttpClient();

    public String getRate(String url) throws IOException, InterruptedException, URISyntaxException {
        URI uri = new URI(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String result = "";
        switch (settings.getBank()) {
            case "Privat":
                if (response.statusCode() == 200) {
                    result = response.body();
                    bufferDatePb = result;
                } else result = bufferDatePb;
                break;
            case "Mono":
                if (response.statusCode() == 200) {
                    result = response.body();
                    bufferDateMb = result;
                } else result = bufferDateMb;
                break;
            case "NBU":
                if (response.statusCode() == 200) {
                    result = response.body();
                    bufferDateNBU = result;
                } else result = bufferDateNBU;
                break;
        }
        return result;
    }
}
