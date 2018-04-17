package com.example.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Matrix {

	private int[][] a;
	private int row, col;

	public Matrix() {

	}

	public Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		a = new int[row][col];
		Random rd = new Random();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				a[i][j] = rd.nextInt(10);
			}
		}
	}

	public int[][] getMatrix() {
		return a;
	}

	public String getStringMatrix() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				String tmp = (a[i][j] < 10 ? "0" + a[i][j] : a[i][j] + "");
				if (j == col - 1)
					str.append(tmp);
				else
					str.append(tmp + " ");
			}
			if (i < row - 1)
				str.append("\r\n");
		}
		return str.toString();
	}
	// public void setMatrix(int row, int col, int value) {
	// a[row][col] = value;
	// }

	public int getRow() { // returns the total number of rows
		return row;
	}

	public int getCol() { // returns the total number of cols
		return col;
	}

	public void createRandomMatrix() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				a[i][j] = (int) (Math.random() * 10);
			}
		}
	}

	public String writeMatrix() {
		String rs = "Success";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("bt180416.txt"))) {
			StringBuilder str = new StringBuilder();
			str.append(this.getCol() + "x" + this.getRow() + "\r\n");
			str.append(this.getStringMatrix());
			bw.write(str.toString());
		} catch (IOException e) {
			e.printStackTrace();
			rs = e.getMessage();
		}

		return rs;
	}

}
