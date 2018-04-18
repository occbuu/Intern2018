package com.boraji.tutorial.springboot.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class MyMatrix {
	private int x=1, y=1, n;
	private Random rand = new Random();
	private String path = "E:\\matrix.txt";
	
	public MyMatrix (int x, int y, String path) {
		this.x = x;
		this.y = y;
		if (path!="")
		{
		this.path = path;
		}
	}
	public int GetM()
	{
		return x;
	}
	
	public void SetM(int m)
	{
		x = m;
	}
	
	public void SetN(int n)
	{
		y = n;
	}
	
	public int GetN()
	{
		return y;
	}
	
	public void SetPath(String path)
	{
		this.path = path;
	}
	
	public String GetPath()
	{
		return path;
	}
	
	public void CreateAndSave() throws IOException
	{
	File file = new File(path);
	Writer output = new BufferedWriter(new FileWriter(file));
	output.write(String.valueOf(x)+"x"+String.valueOf(y)+"\n");
	for (int i=0;i<x;i++)
	{	
		for (int o=0;o<y;o++)
		{
			n = rand.nextInt(10);
	        output.write(String.valueOf(n)+"\t");
		}
		output.write("\n");
	}
	output.close();
	//System.out.println("Saved to "+path+" successfully!");
	}
}