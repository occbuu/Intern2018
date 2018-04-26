package com.demomatrix.oop.utl;

import java.util.Random;

public class Matrix extends Information implements FileHelper {
	// region -- Fields --
	private int data[][];

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
		if (m > 10) {
			m = 10;
		}
		this.m = m;
		this.data = new int[m][n];
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		if (n < 0) {
			n = 0;
		}
		if (n > 10) {
			n = 10;
		}
		this.n = n;
		this.data = new int[m][n];
	}

	// end

	// region -- Methods--

	public Matrix() {
		m = n = 0;
		this.data = new int[m][n];
	}

	public Matrix(int m, int n) {
		this.data = new int[m][n];
	}

	public Matrix(int m, int n, String name) {
		this(m, n);
		setName(name);
	}

	@Override
	public String save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String path) {
		// TODO Auto-generated method stub
		return null;
	}
	public void random() {
		Random rand = new Random();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				data[i][j]=n;
				int n=rand.nextInt(50)+1;
			}
		}
	}
	// end

}