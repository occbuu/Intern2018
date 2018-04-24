package main.java;

import java.util.Scanner;

import main.model.Matrix;

public class Program {
	private static Scanner sc;

	public static void main(String[] args) throws Exception {
		int k,f ;
		sc = new Scanner(System.in);
		System.out.println("Nhập số hàng: ");
		k = sc.nextInt();
		System.out.println("Nhập số cột: ");
		f = sc.nextInt();
		System.out.println("Matrix");
		Matrix c = new Matrix(k, f);
		/*Ghi File*/
		c.SaveMatrix();
		System.out.println("");
		System.out.println("Read MatrixFile");
		Matrix b = new Matrix();
		/*Đọc file*/
		b.ReadMatrix("E:\\matrixfile.txt");
	}
}
