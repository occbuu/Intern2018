package com.example.demo;

public class Matrix {

	int[][] a;
	int row, col;

	Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		a = new int[row][col];
	}

	public double getValue(int row, int col) {
		return a[row][col];
	}

	public void setValue(int row, int col, int value) {
		a[row][col] = value;
	}

	public int getNoRows() { // returns the total number of rows
		return row;
	}

	public int getNoCols() { // returns the total number of cols
		return col;
	}

	public void createRandomMatrix() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				a[i][j] = (int) (Math.random() * 10);
			}
		}
	}

}
