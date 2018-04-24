package com.intern.giang.oop;

import com.intern.giang.oop.clsMatrix.Matrix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        m.PrintMatrix();
        m.MatrixWrite();
    }
}
