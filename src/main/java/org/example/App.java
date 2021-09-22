package org.example;

import java.util.Formatter;


public class App
{
    public static void main( String[] args )
    {
        Formatter form_1 = new Formatter();
        System.out.println(form_1.format("number 173 in octal = %o", 173));

        Formatter form_12 = new Formatter();
        System.out.println(form_12.format("number 173 in octal = %x", 173));

        Formatter form_2 = new Formatter();
        System.out.println(form_2.format("number 173 with floating point = %g", 173.));

        Formatter form_3 = new Formatter();
        System.out.println(form_3.format("number 173 with qualifier in minimal width 40 \n %40f", 173.));

        Formatter form_4 = new Formatter();
        System.out.println(form_4.format("number 173.7899 in qualifier accuracy 3 in width 20 \n %20.3f", 173.7899));

        Formatter form_5 = new Formatter();
        System.out.println(form_5.format(" 5 variants of using flags: \n " +
                        "|%-10.2f| \n % (d \n %.2f \n %.4f \n %n%-3d",
                123.123, -100, 123456789.34, 1111.1111111, 172));

        Formatter form_6 = new Formatter();
        System.out.println(form_6.format(" 5 variants of using flags and index: \n " +
                "%4$.1f %2$.1f %3$d %1$d", 123, 67.091, 1123, 5.0));


    }
}
