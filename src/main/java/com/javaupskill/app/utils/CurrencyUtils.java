package com.javaupskill.app.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UncheckedIOException;
import com.javaupskill.app.model.Currency;

public class CurrencyUtils {
    public static  final ObjectMapper objectMapper = new ObjectMapper();

    public static Currency toCurrency(String response, String code) {
        try{
            String currencyList = objectMapper.readTree(response).get("data").asText();
            Double rate = objectMapper.readTree(currencyList).get(code).asDouble();
            return new Currency(code, rate, code);
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
