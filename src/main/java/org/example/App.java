package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.lang.Math;
import java.text.NumberFormat;
import java.util.Scanner;


class Matrix {

    public static Integer[][] matrixGeneration(int rows, int columns) {
        Integer[][] matrix = new Integer[rows][columns];
        Random rand = new Random();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                matrix[i][j] = rand.nextInt(200) + 1 - 100;
            }
        }
        return matrix;
    }

    public static Integer[][] calcResult(Integer[][] matrix) {
        int maxI = 0, maxJ = 0;

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[maxI][maxJ] < matrix[i][j]) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return swapToLeftCorner(matrix, maxI, maxJ);
    }

    public static Integer[][] swapToLeftCorner(Integer[][] matrix, int maxI, int maxJ) {
        Integer[] row = matrix[0];
        matrix[0] = matrix[maxI];
        matrix[maxI] = row;

        for (int i = 0; i < matrix.length; ++i) {
            Integer value = matrix[i][0];
            matrix[i][0] = matrix[i][maxJ];
            matrix[i][maxJ] = value;
        }

        return matrix;
    }

    public static Integer[] lastRowPartialCopy(Integer[][] matrix, int from, int to) {
        Integer[] res = new Integer[to - from];
        int step = 0;
        for (int i = from; i < matrix[matrix.length - 1].length && i < to; ++i) {
            res[step++] = matrix[matrix.length - 1][i];
        }

        return res;
    }
}

class MatrixComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer emp1, Integer emp2) {
        return emp1.compareTo(emp2) * -1;
    }
}

public class App 
{
    public static void main( String[] args ) {
        int rows;
        int columns;
        Scanner in = new Scanner(System.in);

        System.out.println("Number of rows :");
        rows = Integer.parseInt(in.nextLine());

        System.out.println("Number of columns :");
        columns = Integer.parseInt(in.nextLine());

        Integer[][] matrix = Matrix.matrixGeneration(rows, columns);

        System.out.println("Matrix of integer is:");
        NumberFormat form = NumberFormat.getInstance();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.print(form.format(matrix[i][j]) + "  ");
            }
            System.out.println("  ");
        }

        Integer[][] res = Matrix.calcResult(matrix);

        System.out.println("Matrix with biggest element in top left corner:");
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[i].length; ++j) {
                System.out.print(form.format(res[i][j]) + "  ");
            }
            System.out.println("  ");
        }

        Arrays.sort(res[res.length - 1], new MatrixComparator());

        System.out.println("Matrix with sorted last row:");
        for (int i = 0; i < res.length; ++i) {
            for (int j = 0; j < res[i].length; ++j) {
                System.out.print(form.format(res[i][j]) + "  ");
            }
            System.out.println("  ");
        }

        System.out.println("\ncopy from :");
        int copyFrom = Integer.parseInt(in.nextLine());

        System.out.println("\ncopy to :");
        int copyTo = Integer.parseInt(in.nextLine());

        Integer[] copy = Matrix.lastRowPartialCopy(res, copyFrom - 1, copyTo);

        System.out.println("\nCopied part of last row:  ");
        for (int j = 0; j < copy.length; ++j) {
            System.out.print(form.format(copy[j]) + "  ");
        }

    }


}
