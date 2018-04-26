package com.matrix.oop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.matrix.oop.ult.Matrix;

import java.util.Scanner;

@SpringBootApplication
public class OopApplication {

    public static void main(String[] args) {
        SpringApplication.run(OopApplication.class, args);
        Scanner scan = new Scanner(System.in);

        System.out.print("Input number of columns: ");
        int a = scan.nextInt();

        System.out.print("Input number of rows: ");
        int b = scan.nextInt();

        Matrix m = new Matrix(a, b);
        m.printMatrix();
        m.writeMatrix();
    }
}