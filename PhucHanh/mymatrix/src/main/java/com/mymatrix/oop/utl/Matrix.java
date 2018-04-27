package com.mymatrix.oop.utl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Matrix extends Information implements FileHelper {

	// region -- Fields --
	private int data[][];
	private String path = "E:\\matrix.txt";
	private int m;
	private int n;
	// end

	// region -- Get set --
	public int[][] getData() {
		return data;
	}

	public void setData(int[][] data) {
		this.data = data;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		if (m < 0) {
			m = 0;
		}
		if (m > 20) {
			m = 20;
		}

		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n < 0) {
			n = 0;
		}
		if (n > 20) {
			n = 20;
		}

		this.n = n;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	// end

	// region -- Methods --

	public Matrix() {
		this.data = new int[m][n];

	}

	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		random();
	}

	public Matrix(int m, int n, String name) {
		this(m, n);
		setName(name);
		random();
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(String path) {
		String res = toString();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(res);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String path) throws IOException {
		if (path == null || path.equals("")) {
			path = "E:\\matrix.txt";
		}
		File file = new File(path);
		@SuppressWarnings("resource")
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

	/***
	 * Add data to matrix with random value
	 */
	public void random() {
		data = new int[m][n];
		Random rd = new Random();
		// Add data
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int a = rd.nextInt(50) + 1;
				data[i][j] = a;

			}
		}
	}
	// end

	@Override
	public void Test() {
		// TODO Auto-generated method stub

	}

	

}