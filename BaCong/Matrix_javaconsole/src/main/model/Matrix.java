package main.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class Matrix {
	private int m = 1, n = 1;
	private int a[][];
	private String path = "E:\\matrixfile.txt";

	public Matrix() {
	}

	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		this.a = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int random = (int) (Math.random() * 100 + 1);
				a[i][j] = random;
				System.out.print(a[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int[][] getMatrix() {
		return a;
	}

	public void SaveMatrix() throws Exception {
		File file = new File(path);
		Writer output = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				output.write(a[i][j] + " ");
			}
			output.write("\r\n");
		}
		output.close();
	}

	public void ReadMatrix(String path) throws Exception {
		FileReader fr = new FileReader(path);
		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
		fr.close();
	}
}
