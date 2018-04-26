package com.matrix.oop.ult;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Matrix extends Information implements FileHelper {
    private int col;
    private int row;
    private int[][] i; //items

    public int getCol()
    {
        return this.col;
    }

    public void setCol(int n)
    {
        if (n<=0){
            n=1;
        }
        if (n>10){
            n=10;
        }

        this.col = n;
    }

    public int getRow()
    {
        return this.row;
    }

    public void setRow(int n)
    {
        if (n<=0){
            n=1;
        }
        if (n>10){
            n=10;
        }

        this.row = n;
    }

    public Matrix()
    {
        this.col = 1;
        this.row = 1;
        i = new int[row][col];

        for (int a = 0; a < this.row; a++) {
            for (int b = 0; b < this.col; b++) {
                Random rand = new Random();
                int val = rand.nextInt(99) + 1;
                i[a][b] = val;
            }
        }
    }

    public Matrix(int col)
    {
        this.col = col;
        this.row = 1;
        i = new int[row][col];

        for (int a = 0; a < this.row; a++) {
            for (int b = 0; b < this.col; b++) {
                Random rand = new Random();
                int val = rand.nextInt(99) + 1;
                i[a][b] = val;
            }
        }
    }

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

    public Matrix(int col, int row, String name) {
        this.col = col;
        this.row = row;
        i = new int[row][col];
        setName(name);

        for (int a = 0; a < this.row; a++) {
            for (int b = 0; b < this.col; b++) {
                Random rand = new Random();
                int val = rand.nextInt(99) + 1;
                i[a][b] = val;
            }
        }
    }

    public void printMatrix() {
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < col; b++) {
                System.out.print("\t" + i[a][b]);
            }
            System.out.println();
        }
    }

    public void writeMatrix() {
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