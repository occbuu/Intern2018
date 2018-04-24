package skg.matrix;

import java.util.ArrayList;
import java.util.List;

import skg.matrix.utl.Information;
import skg.matrix.utl.Matrix;
import skg.matrix.utl.Point;

public class Program {

	public static void main(String[] args) {
		Matrix a = new Matrix();
		Matrix b = new Matrix(3, 3);
		Matrix c = new Matrix(3, 3, "C");

		try {
			c.setM(12);
		} catch (Exception e) {
			if (e.getMessage().contains("Over")) {
				try {
					c.setM(5);
				} catch (Exception ex) {
				}

			}
			if (e.getMessage().contains("101")) {
				try {
					c.setM(11);
				} catch (Exception ex) {
				}

			}
			e.printStackTrace();
		}

		System.out.println(c.getM());
		a.setName("A");
		b.setName("B");

		Point m = new Point();
		m.setName("M");
		/// m.set

		List<Information> list = new ArrayList<Information>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(m);

		for (Information i : list) {
			i.Test();
		}

	}
}