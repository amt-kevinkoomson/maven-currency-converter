package com.javaupskill.app.model;

public class Currency {
    public String name;
    public String code;
    public Double rate;
    public Currency(String currencyName, Double exchangeRate, String currencyCode){
        name = currencyName;
        rate = exchangeRate;
        code = currencyCode;
    }
    public Double convertTo (Double amount, Currency targetCurrency) {
        Double amountInUsd = amount / rate;
        return amount * targetCurrency.rate;
    }
}
