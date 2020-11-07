package com.listings;

import java.util.Scanner;

public class L04_CheckSudokuSolution
{
    public static void main(String[] args)
    {
        int[][] sudoku = readASolution();
        System.out.println();
        System.out.println(isValid(sudoku) ? "Valid solution" : "Invalid solution");
        System.out.println();
    }

    public static int[][] readASolution()
    {
        int[][] sudoku = new int[9][9];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Sudoku puzzle solution: ");
        String str = input.nextLine();

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                sudoku[i][j] = str.charAt(i * 9 + j);

        return sudoku;
    }

    public static boolean isValid(int[][] sudoku)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                boolean x = isUniqueInColumn(sudoku, i, j);
                boolean y = isUniqueInRow(sudoku, i, j);
                boolean z = isUniqueInRegion(sudoku, i, j);
                if (!(x && y && z))
                    return false;
            }
        }
        return true;
    }

    public static boolean isUniqueInRow(int[][] sudoku, int row, int col)
    {
        for (int j = 0; j < 9; j++)
        {
            if (j == col)
                continue;

            if (sudoku[row][j] == sudoku[row][col])
                return false;
        }

        return true;
    }

    public static boolean isUniqueInColumn(int[][] sudoku, int row, int col)
    {
        for (int i = 0; i < 9; i++)
        {
            if (i == row)
                continue;

            if (sudoku[i][col] == sudoku[row][col])
                return false;
        }

        return true;
    }

    public static boolean isUniqueInRegion(int[][] sudoku, int row, int col)
    {
        int region = ((row / 3) * 3) + col / 3;

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (row == i && col == j)
                    continue;

                if (sudoku[i][j] == sudoku[row][col] && region == getRegion(i, j))
                    return false;
            }
        }

        return true;
    }

    public static int getRegion(int row, int col)
    {
        return ((row / 3) * 3) + col / 3;
    }
}
