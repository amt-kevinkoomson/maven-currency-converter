package com.javaupskill.app.model;

import static org.junit.Assert.*;

import com.javaupskill.app.model.Currency;
import org.junit.Test;

public class CurrencyTest {

    @Test
    public void testConvertTo() {
        // Create instance of Currency for testing
        Currency usd = new Currency("US Dollar", 1.0, "USD");
        Currency euro = new Currency("Euro", 0.85, "EUR");

        // Test converting 100 USD to Euro
        Double amountInEuro = usd.convertTo(100.0, euro);
        assertEquals(85.0, amountInEuro, 0.001);

        // Test converting 100 Euro to USD
        Double amountInUSD = euro.convertTo(100.0, usd);
        assertEquals(117.647, amountInUSD, 0.001);
    }
}
