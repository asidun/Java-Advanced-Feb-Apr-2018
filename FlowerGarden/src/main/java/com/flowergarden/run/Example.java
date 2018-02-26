package com.flowergarden.run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example {

	public static void main(String[] args) {
		String content = "Hello!!";
		//BufferedWriter bw = null;
		
		File file = new File("file.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try (FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
				BufferedWriter bw = new BufferedWriter(fw)) {	
			bw.write(content);
		} catch (Exception e) {
			System.out.println("Ошибка записи в файл \n" + file.getAbsolutePath());
		}

	}
}
