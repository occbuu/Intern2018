package DemoMT;

import java.util.*;
import java.io.*;
import javax.imageio.stream.FileCacheImageInputStream;

public class Matrix {
	public static void nhapMaTran(int A[][], int m, int n) {
		Random rand = new Random();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = rand.nextInt(30);
			}
		}
	}

	public static void xuatMaTran(int A[][], int m, int n) {
		for (int i = 0; i < m; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print("\t" + A[i][j] + "\t");
			}
		}
	}

	public static void saveMT(int A[][], int m, int n) throws IOException {
		File f = new File("demo.txt");
		Writer ouput = new BufferedWriter(new FileWriter(f));

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ouput.write(A[i][j] + "");
			}
			ouput.write("\r\n");
		}
		ouput.close();
	}

	public static void readMT(int A[][], int m, int n) throws IOException {
		File f = new File("demo.txt");
		FileReader fr = new FileReader(f);
		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
		fr.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.print("Nhap so dong: ");
		int m = input.nextInt();
		System.out.print("Nhap so cot: ");
		int n = input.nextInt();
		int A[][] = new int[m][n];
		nhapMaTran(A, m, n);
		System.out.println("Ma tran co dang:");
		xuatMaTran(A, m, n);
		saveMT(A, m, n);
		System.out.println("\nDoc file:");
		readMT(A, m, n);
	}
}