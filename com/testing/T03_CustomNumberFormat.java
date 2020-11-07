package com.testing;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class T03_CustomNumberFormat
{
    public static void main(String[] args)
    {
        System.out.println(cnf(123456.799)); // 123 456.8
        System.out.println(cnf(0.123));      // 0.12
        System.out.println(cnf(123456789));  // 123 456 789
    }

    public static String cnf(double number)
    {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(' ');
        String pattern = "#,##0.##";
        DecimalFormat df = new DecimalFormat(pattern, symbols);
        return  df.format(number);
    }
}
