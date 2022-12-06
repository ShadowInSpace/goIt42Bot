package com.jc8pg2.telegrambot.currency.bankrates;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.jc8pg2.telegrambot.currency.convertion.NationalBankRate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class NationalBankGetRate {

    public List<NationalBankRate> getRate() {
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

        Gson gson = new Gson();
        List<NationalBankRate> nationalBankRates = gson.fromJson(response.body(),
                new TypeToken<List<NationalBankRate>>(){}.getType());
        StringBuilder sb = new StringBuilder("Валюти по курсу Національного банку\n\n");
        for (NationalBankRate m : nationalBankRates) {
            sb.append("UAH").append(" to ").append(m.getCc())
                    .append("\nSell: ").append(m.getRate()).append("\n");
        }

        return nationalBankRates;
    }
}
