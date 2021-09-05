package org.example;


import java.util.ArrayList;

public class ArrayFunc {
    public static int Accumulate(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            if (j % 2 == 0 && j >= 0) {
                sum += j;
            }
        }
        System.out.println(sum);
        return sum;

    }
    public static void main( String[] args ) {

    }

}
