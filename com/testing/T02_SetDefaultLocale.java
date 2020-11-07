package com.testing;

import java.text.NumberFormat;
import java.util.Locale;

public class T02_SetDefaultLocale
{
    public static void main(String[] args) throws Exception {

        System.out.println("Default locale:" + Locale.getDefault().toString());
        formattedDoubleTest();

        System.out.println("\nSetting default locale to swedish_sweden");
        Locale swedishLocale = new Locale("sv", "SE");
        Locale.setDefault(swedishLocale);

        System.out.println("New default locale:" + Locale.getDefault().toString());
        formattedDoubleTest();

    }

    public static void formattedDoubleTest() {
        double num = 1234567.89;
        Locale defaultLocale = Locale.getDefault();
        NumberFormat numberFormat = NumberFormat.getInstance(defaultLocale);
        String formattedNum = numberFormat.format(num);
        System.out.println(num + " formatted (" + defaultLocale.toString() + "):" + formattedNum);
    }
}
