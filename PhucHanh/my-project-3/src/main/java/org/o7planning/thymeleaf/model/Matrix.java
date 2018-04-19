package org.o7planning.thymeleaf.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.File;
import java.io.FileInputStream;

public class Matrix {
	private int m = 1, n = 1;
	private String path = "E:\\matrix.txt";
	private int a[][];

	public Matrix(int m, int n, String path)

	{
		this.m = m;
		this.n = n;
		if (path != "") {
			this.path = path;
		}
		this.a = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int random = (int) (Math.random() * 100 + 1);
				a[i][j] = random;
			}
		}
	}

	public int GetX() {
		return m;
	}

	public void SetX(int x) {
		m = x;
	}

	public void SetY(int y) {
		n = y;
	}

	public int GetY() {
		return n;
	}

	public void SetPath(String path) {
		this.path = path;
	}

	public String GetPath() {
		return path;
	}

	public int[][] getMatrix() {
		return a;
	}

	public void Save() throws Exception {
		File file = new File(path);
		Writer output = new BufferedWriter(new FileWriter(file));
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k++) {
				output.write(a[i][k] + " ");
			}
			output.write("\r\n");
		}
		output.close();
	}

	public String Read(String path) throws Exception {
		if(path==null || path.equals("")) {
			path = "E:\\matrix.txt";
		}
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		char current;
		String temp = "";
		int i = 0;
		while (fis.available() > 0) {
			current = (char) fis.read();
			if (i == 0) {
				temp += "<br>";
			}
			if (current == '\n') {
				temp += "<br>";
			} else {
				temp += Character.toString(current);
			}
			i++;
		}
		return temp;
	}

}
