package com.intern.giang.oop.clsMatrix;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Matrix {
    private int col;
    private int row;
    private int[][] i; //items

    public Matrix(int col, int row) {
        this.col = col;
        this.row = row;
        i = new int[row][col];

        for (int a = 0; a < this.row; a++) {
            for (int b = 0; b < this.col; b++) {
                Random rand = new Random();
                int val = rand.nextInt(99) + 1;
                i[a][b] = val;
            }
        }
    }

    public void PrintMatrix() {
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < col; b++) {
                System.out.print("\t" + i[a][b]);
            }
            System.out.println();
        }
    }

    public void MatrixWrite() {
        PrintWriter writer;
        try
        {
            writer = new PrintWriter(new FileWriter("matrix-output.txt"));
            for (int a = 0; a < row; a++)
            {
                for (int b = 0; b < col; b++)
                {
                    writer.print("\t" + i[a][b]);
                }
                writer.println();
            }
            writer.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
