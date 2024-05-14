package com.javaupskill.app.api;

import com.javaupskill.app.model.Currency;
import com.javaupskill.app.utils.CurrencyUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;


public class CurrencyApi {
    private static final String PROPERTIES_FILE_PATH = "src/main/resources/application.properties";

    private static final HttpClient client = HttpClient.newHttpClient();

    public static Currency getCurrency(String code) {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(PROPERTIES_FILE_PATH);
            properties.load(fis);
            String apiKey = properties.getProperty("api-key");
            String baseUrl = properties.getProperty("api-url");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl))
                    .GET()
                    .setHeader("Content-Type", "application/json")
                    .setHeader("apikey", apiKey)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println(response.body());
            return CurrencyUtils.toCurrency(response.body(), code);

        } catch(IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
    public static void main(String...args){
        Currency s = getCurrency("AUD");
        System.out.println(s.toString());
    }
}
