package com.spring.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Readers {

	public static List<String> readerTxt(String file) {
		List<String> list = new ArrayList<>();
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "java" + File.separator + file;
		File theFile = new File(path);

		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				list.add(tempLine);
			}

		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

}
