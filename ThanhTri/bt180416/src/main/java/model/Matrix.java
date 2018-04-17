package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Matrix {
	private int c;
	private int r;
	private int[][] data;

	public String getData() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				String tmp = (data[i][j] < 10 ? "0" + data[i][j] : data[i][j] + "");
				if (j == c - 1)
					str.append(tmp);
				else
					str.append(tmp + " ");
			}
			if (i < r - 1)
				str.append("\r\n");
		}
		return str.toString();
	}

	public void setData(String data) {
		this.data = new int[this.getC()][this.getR()];

	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		int col = c == 0 || c >= 15 ? 1 : c;
		this.c = col;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		int row = r == 0 || r >= 15 ? 1 : r;
		this.r = row;
	}

	public Matrix(int c, int r, Random ran) {
		this.c = c;
		this.r = r;
		data = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				data[i][j] = ran.nextInt(100);
			}
		}
	}

	public String save() {
		String rs = "Success";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("bt180416.txt"))) {
			StringBuilder str = new StringBuilder();
			str.append(this.getC() + "x" + this.getR() + "\r\n");
			str.append(this.getData());
			bw.write(str.toString());
		} catch (IOException e) {
			e.printStackTrace();
			rs = e.getMessage();
		}

		return rs;
	}

	public Matrix() {

	}

}
