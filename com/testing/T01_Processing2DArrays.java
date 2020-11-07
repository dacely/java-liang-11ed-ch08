package com.testing;

import java.util.Scanner;

public class T01_Processing2DArrays
{
    public static void main(String[] args)
    {
        /*int[][] userArray = getUserArray();
        System.out.println("\nYour array is:");
        printArray2D(userArray);*/

        int[][] randArray = getRandomMatrix(3, 3, 10);
        System.out.println("Rand array is:");
        printArray2D(randArray);

        System.out.println();
        System.out.printf("Sum of all elements is: %d", sumAllElements(randArray));

        System.out.println("\n");
        System.out.print("Sum by columns:\n\t");
        int[] sumColumns = sumByColumn(randArray);
        printArray1D(sumColumns);
        System.out.println();
        int[] maxCol = maxValueArray1D(sumColumns);
        System.out.printf("\t Max col: col #%d, sum = %d", maxCol[1] + 1, maxCol[0]);

        System.out.println("\n");
        int[] sumRows = sumByRow(randArray);
        System.out.print("Sum by rows:\n\t");
        printArray1D(sumRows);
        System.out.println();
        int[] maxRow = maxValueArray1D(sumRows);
        System.out.printf("\t Max row: row #%d, sum = %d", maxRow[1] + 1, maxRow[0]);

        System.out.println("\n");
        System.out.println("Shuffled array:");
        shuffleMatrix(randArray);
        printArray2D(randArray);
    }

    public static int[][] getUserArray()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix size (e.g, 3 x 5): ");
        String[] arrOfStr = input.nextLine().split("x");
        int rows = Integer.parseInt(arrOfStr[0].trim());
        int columns = Integer.parseInt(arrOfStr[1].trim());
        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the matrix's values:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = input.nextInt();

        return matrix;
    }

    public static void printArray2D(int[][] array)
    {
        int maxWidth = 1;

        for (int[] row : array)
            for (int num : row)
            {
                int numWidth = countDigits(num);
                if (numWidth > maxWidth)
                    maxWidth = numWidth;
            }

        String formatOutput = "%" + (maxWidth + 2) + "d";
        for (int[] row : array)
        {
            System.out.print("\t");
            for (int val : row)
                System.out.printf(formatOutput, val);
            System.out.println();
        }
    }

    public static int countDigits(int num)
    {
        int count = 0;

        while(num != 0)
        {
            num /= 10;
            ++count;
        }

        return count;
    }

    public static int[][] getRandomMatrix(int rows, int columns, int maxValue)
    {
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = (int) ((maxValue + 1) * Math.random());

        return matrix;
    }

    public static int sumAllElements(int[][] array)
    {
        int total = 0;
        for (int[] row : array)
            for (int element : row)
                total += element;

        return total;
    }
    
    public static int[] sumByColumn(int[][] array)
    {
        int[] sum = new int[array[0].length];

        for (int j = 0; j < array[0].length; j++)
            for (int i = 0; i < array.length; i++)
                sum[j] += array[i][j];

        return sum;
    }

    public static void printArray1D(int[] array)
    {
        for (int element : array)
            System.out.printf(" %d", element);
    }

    public static int[] sumByRow(int[][] array)
    {
        int[] sum = new int[array.length];

        for (int r = 0; r < array.length; r++)
            for (int element : array[r])
                sum[r] += element;

        return sum;
    }

    /**
     * Return an array with the max value and the position index of max value
     * @param array array with integer values
     * @return result[0] = max value, result[1] = index of max value
     */
    public static int[] maxValueArray1D(int[] array)
    {
        int[] result = new int[2];
        result[0] = array[0];

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > result[0])
            {
                result[0] = array[i];
                result[1] = i;
            }
        }

        return result;
    }

    public static void shuffleMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                int i1 = (int) (Math.random() * matrix.length);
                int j1 = (int) (Math.random() * matrix[0].length);

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i1][j1];
                matrix[i1][j1] = temp;
            }
        }
    }
}
