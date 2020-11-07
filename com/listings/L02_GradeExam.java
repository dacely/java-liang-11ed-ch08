package com.listings;

import com.testing.T01_Processing2DArrays;

public class L02_GradeExam
{
    public static void main(String[] args)
    {
        char[][] answers = {
                {'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
                {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
                {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
                {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

        char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
        int[] grades = new int[answers.length];

        for (int i = 0; i < answers.length; i++)
            for (int j = 0; j < answers[i].length; j++)
                if (answers[i][j] == keys[j])
                    ++grades[i];

        for (int i = 0; i < grades.length; i++)
            System.out.printf("Student %d's correct count is %d\n", i, grades[i]);

        int[] highest = T01_Processing2DArrays.maxValueArray1D(grades);
        System.out.println();
        System.out.printf("The highest correct count is %d for student %d", highest[0], highest[1]);
    }
}
