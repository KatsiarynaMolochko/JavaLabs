package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.lang.Math;
import java.util.Scanner;
import java.math.RoundingMode;



class MathCalc {
    private static final BigDecimal ZERO_D = BigDecimal.valueOf(0);
    private static final BigDecimal ONE_D = BigDecimal.valueOf(1);

    private static final BigInteger ZERO_I = BigInteger.valueOf(0);
    private static final BigInteger ONE_I = BigInteger.valueOf(1);


    public static BigDecimal pow(BigDecimal x, BigInteger n) {
        BigDecimal result = ONE_D;

        for (BigInteger i = ZERO_I; i.compareTo(n) < 0; i = i.add(ONE_I)) {
            result = result.multiply(x);
        }

        return result;
    }


    public static BigDecimal Series(double x, int k) {
        final BigDecimal big_x = BigDecimal.valueOf(x);
        final BigInteger big_k = BigInteger.valueOf(k);
        BigDecimal component = big_x;

        final BigDecimal EPS = BigDecimal.ONE.divide(
                pow(BigDecimal.valueOf(10), big_k)
         );

        BigDecimal right = BigDecimal.ZERO;
        BigInteger step = ONE_I;
        BigDecimal step_d = ONE_D;

        while (component.compareTo(EPS) > 0) {
            component = pow(big_x, step).divide(step_d, k+1, RoundingMode.HALF_UP);
            right = right.subtract(component);
            step = step.add(ONE_I);
            step_d = step_d.add(ONE_D);
        }

        return right;
    }
    public static BigDecimal StandartSeries (double x, int k) {
        final BigDecimal left = BigDecimal.valueOf(Math.log(1 - x));

        return left;
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
        System.out.println("Series Calculations: " + MathCalc.Series(x, k));
        System.out.println("Standard Calculations: " + MathCalc.StandartSeries(x, k));
    }
}
