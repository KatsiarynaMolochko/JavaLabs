package org.example;

import java.lang.Math;
import java.util.Scanner;
import java.util.Formatter;
import java.math.RoundingMode;



class MathCalc {
    public static double pow(double x, int n) {
        double result = 1.0;
        for (int i = 0; i < n; ++i) {
            result *= x;
        }
        return result;
    }


    public static double Series(double x, int k) {
        double component = x;
        double EPS = (1.0/pow(10.0, k));
        double right = 0.0;
        double step_d = 1.0;
        int step_i = 1;

        while (component > EPS) {
            component = pow(x, step_i)/(step_d);
            right -= component;
            ++step_i;
            ++step_d;

        }
        return right;
    }


    public static double StandartSeries (double x) {
        return Math.log(1 - x);
    }


}
public class App
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Input x: ");
        double x = in.nextDouble();
        if (x < -1 || x >= 1) {
            System.out.println("x should belongs to interval [-1; 1)");
            return;
        }
        System.out.println("Input k: ");
        int k = in.nextInt();
        if (k < 0) {
            System.out.println("k should be positive:");
            return;
        }

        System.out.println("Series Calculations: " + MathCalc.Series(x,k));
        System.out.println("Standard Calculations: " + MathCalc.StandartSeries(x));
    }
}
