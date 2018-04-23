package skg.matrix.utl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
	}

	// end

	// region -- Methods --

	public Matrix() {
		m = n = 0;
		data = new int[m][n];
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
	public String read(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Add data to matrix with random value
	 */
	public void random() {
		data = new int[m][n];
		Random rand = new Random();

		// Add data
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int n = rand.nextInt(50) + 1;
				data[i][j] = n;
			}
		}
	}

	public String toString() {
		String res = String.format("Matrix %s\n", getName());

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res += data[i][j] + " ";
			}
			res += "\n";

		}

		return res;
	}

	public double det() {
		return determinant(data);
	}

	public Matrix invert() {
		Matrix mt = new Matrix();
		int tmp[][] = invertMatrix(data);
		mt.setData(tmp);
		return mt;
	}

	private static double determinant(int[][] matrix) {
		int tmp[][];
		double res = 0;

		if (matrix.length == 1) {
			res = matrix[0][0];
			return (res);
		}

		if (matrix.length == 2) {
			res = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
			return (res);
		}

		for (int i = 0; i < matrix[0].length; i++) {
			tmp = new int[matrix.length - 1][matrix[0].length - 1];

			for (int j = 1; j < matrix.length; j++) {
				for (int k = 0; k < matrix[0].length; k++) {
					if (k < i) {
						tmp[j - 1][k] = matrix[j][k];
					} else if (k > i) {
						tmp[j - 1][k - 1] = matrix[j][k];
					}
				}
			}

			res += matrix[0][i] * Math.pow(-1, (double) i) * determinant(tmp);
		}

		return (res);
	}

	private static int[][] invertMatrix(int[][] matrix) {
		int[][] auxiliaryMatrix, invertedMatrix;
		int[] index;

		auxiliaryMatrix = new int[matrix.length][matrix.length];
		invertedMatrix = new int[matrix.length][matrix.length];
		index = new int[matrix.length];

		for (int i = 0; i < matrix.length; ++i) {
			auxiliaryMatrix[i][i] = 1;
		}

		transformToUpperTriangle(matrix, index);

		for (int i = 0; i < (matrix.length - 1); ++i) {
			for (int j = (i + 1); j < matrix.length; ++j) {
				for (int k = 0; k < matrix.length; ++k) {
					auxiliaryMatrix[index[j]][k] -= matrix[index[j]][i] * auxiliaryMatrix[index[i]][k];
				}
			}
		}

		for (int i = 0; i < matrix.length; ++i) {
			invertedMatrix[matrix.length - 1][i] = (auxiliaryMatrix[index[matrix.length - 1]][i]
					/ matrix[index[matrix.length - 1]][matrix.length - 1]);

			for (int j = (matrix.length - 2); j >= 0; --j) {
				invertedMatrix[j][i] = auxiliaryMatrix[index[j]][i];

				for (int k = (j + 1); k < matrix.length; ++k) {
					invertedMatrix[j][i] -= (matrix[index[j]][k] * invertedMatrix[k][i]);
				}

				invertedMatrix[j][i] /= matrix[index[j]][j];
			}
		}

		return (invertedMatrix);
	}

	private static void transformToUpperTriangle(int[][] matrix, int[] index) {
		int[] c;
		int c0, c1, pi0, pi1, pj;
		int itmp, k;

		c = new int[matrix.length];

		for (int i = 0; i < matrix.length; ++i) {
			index[i] = i;
		}

		for (int i = 0; i < matrix.length; ++i) {
			c1 = 0;

			for (int j = 0; j < matrix.length; ++j) {
				c0 = Math.abs(matrix[i][j]);

				if (c0 > c1) {
					c1 = c0;
				}
			}

			c[i] = c1;
		}

		k = 0;

		for (int j = 0; j < (matrix.length - 1); ++j) {
			pi1 = 0;

			for (int i = j; i < matrix.length; ++i) {
				pi0 = Math.abs(matrix[index[i]][j]);
				pi0 /= c[index[i]];

				if (pi0 > pi1) {
					pi1 = pi0;
					k = i;
				}
			}

			itmp = index[j];
			index[j] = index[k];
			index[k] = itmp;

			for (int i = (j + 1); i < matrix.length; ++i) {
				pj = matrix[index[i]][j] / matrix[index[j]][j];
				matrix[index[i]][j] = pj;

				for (int l = (j + 1); l < matrix.length; ++l) {
					matrix[index[i]][l] -= pj * matrix[index[j]][l];
				}
			}
		}
	}

	// end
}