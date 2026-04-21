package com.pega.pilot.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CurrencyFormatterUtil {

    public static String formatGermanEuro(String rawNumber) {
        BigDecimal value = new BigDecimal(rawNumber);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.GERMAN);
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat format = new DecimalFormat("0.00", symbols);
        return format.format(value) + " €";
    }
}
