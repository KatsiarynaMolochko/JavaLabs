package org.example;


import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        MatrixWithCircle matrix = new MatrixWithCircle("in.txt");
        matrix.writeResult("ans.txt");
    }
}
