package com.springboot.controller;

import java.io.File;
import java.io.FileInputStream;

public class ReadMatrix  {
	private String path = "E:\\matrix.txt";
	private FileInputStream fis;
	public ReadMatrix(String path)
	{
		if (path != "")
		{
		this.path = path;
		}
	}
	
	public String Show() throws Exception {
		File file = new File(path);
		fis = new FileInputStream(file);
	      char current;
	      String temp = "";
	      int i=0;
	      while (fis.available() > 0) {
	        current = (char) fis.read();
	        if (i==0)
	        {
	        	temp += "<br>";
	        }
	        if (current == '\n')
	        {
	        	temp += "<br>";
	        }
	        else
	        {
	        	temp += Character.toString(current);
	        }
	        i++;
	      }
	     return temp;
	}
}