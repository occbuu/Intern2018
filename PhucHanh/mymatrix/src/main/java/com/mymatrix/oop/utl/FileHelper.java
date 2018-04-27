package com.mymatrix.oop.utl;

import java.io.IOException;

public interface FileHelper {
	/**
	 * Save data to current path file name
	 * 
	 * @return
	 */
	String save();

	/**
	 * Save data to file
	 * 
	 * @param path
	 *            Full path and file name
	 * @return
	 */
	String save(String path);

	/**
	 * Read data from file current path file name
	 * 
	 * @return
	 */
	String read();

	/**
	 * Read data from file
	 * 
	 * @param path
	 *            Full path and file name
	 * @return
	 * @throws IOException 
	 */
	String read(String path) throws IOException;

}