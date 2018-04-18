package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
	int n = 3, m = 3;
	static Matrix mat = new Matrix(3, 3);

	public void createRandomMatrix() {
		mat.createRandomMatrix();

	}

	public static void print2D(int mat[][]) {
		List<String> lines;
		for (int[] row : mat)

			// converting each row as string
			// and then printing in a separate line
			lines = Arrays.toString(row);
		// System.out.println(Arrays.toString(row));
		// Arrays.asList("The first line", "The second line");
		Path file = Paths.get("the-file-name.txt");
		try {
			Files.write(file, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Loop through all rows

	}

	public static void main(String args[]) throws IOException {

		print2D(mat.getMatrix());
	}

}
