package com.listings;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class L03_FindNearestPoints
{
    public static void main(String[] args)
    {
        final int NUMBER_OF_POINTS = 10;
        double[][] points = new double[NUMBER_OF_POINTS][2];

        for (int i = 0; i < NUMBER_OF_POINTS; i++)
        {
            points[i][0] = (Math.random() * 20) - 10;
            points[i][1] = (Math.random() * 20) - 10;
            System.out.printf("\tP%03d: (%5s, %5s)\n", i + 1, cnf(points[i][0]), cnf(points[i][1]));
        }

        int p1 = 0;
        int p2 = 1;
        double minDistance = distance(points[p1], points[p2]);

        for (int i = 1; i < NUMBER_OF_POINTS - 1; i++)
        {
            double tempDistance = distance(points[i], points[i + 1]);
            if (tempDistance < minDistance)
            {
                minDistance = tempDistance;
                p1 = i;
                p2 = i + 1;
            }
        }

        System.out.println();
        System.out.println("Nearest points:");
        System.out.printf("\tP%03d: (%5s, %5s)\n", p1 + 1, cnf(points[p1][0]), cnf(points[p1][1]));
        System.out.printf("\tP%03d: (%5s, %5s)\n", p2 + 1, cnf(points[p2][0]), cnf(points[p2][1]));
        System.out.printf("Distance: %s", cnf(minDistance));
        System.out.println();
    }

    public static double distance(double[] p1, double[] p2)
    {
        return Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
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
