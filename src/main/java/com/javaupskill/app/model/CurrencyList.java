package com.javaupskill.app.model;

import com.javaupskill.app.api.CurrencyApi;

import java.util.ArrayList;
import java.util.List;

public class CurrencyList {
    public List<Currency> currencies;

    public CurrencyList (){
        currencies = new ArrayList<>();
    }
    public void addCurrency(Currency currency) {
        currencies.add(currency);
    }
}
