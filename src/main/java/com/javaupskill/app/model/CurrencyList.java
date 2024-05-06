package com.javaupskill.app.model;

import com.javaupskill.app.api.CurrencyApi;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class CurrencyList {
    public List<Currency> currencies;
    private static final CurrencyApi currencyApi = new CurrencyApi();
    public CurrencyList (){
        currencies = new ArrayList<>();
    }
    public void addCurrency(String name, Double rate) {
        // make api call
        String response = currencyApi.getCurrency(name);
    }
}
