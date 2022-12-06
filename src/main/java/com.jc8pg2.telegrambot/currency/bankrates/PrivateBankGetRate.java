package com.jc8pg2.telegrambot.currency.bankrates;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jc8pg2.telegrambot.currency.convertion.PrivateBankRate;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class PrivateBankGetRate  {

    public List<PrivateBankRate> getRate() {
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

        Gson gson = new Gson();
        List<PrivateBankRate> currencies = gson.fromJson(response.body(),
                new TypeToken<List<PrivateBankRate>>() {
                }
                        .getType());

        StringBuilder sb = new StringBuilder();

        sb.append("PrivateBank Currency \n");
        for (PrivateBankRate o : currencies) {
            sb.append("\n").append(o.getBaseCurrency()).append(" to ").append(o.getCurrency()).append("\n");
            sb.append("Buy: ").append(o.getBuy()).append("\n").append("Sell: ").append(o.getSale()).append("\n");
        }

        return currencies;
    }
}
