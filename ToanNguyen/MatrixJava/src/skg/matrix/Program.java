package skg.matrix;

import skg.matrix.utl.Matrix;

public class Program {

	public static void main(String[] args) {
		Matrix a = new Matrix();
		Matrix b = new Matrix(3, 3);
		Matrix c = new Matrix(3, 3, "C");

		a.save();
		a.save("D:\\A.txt");

		b.setName("B");
		b.save("D:\\B.txt");

		c.setName("C");
		c.save("D:\\C.txt");

		System.out.println(a.toString());

		System.out.println(b.toString());
		System.out.println(b.det());

		System.out.println(c.toString());
		System.out.println(c.det());

		Matrix d = c.invert();
		System.out.println(d.toString());
		c.save("D:\\D.txt");
	}
}