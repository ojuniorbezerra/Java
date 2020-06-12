package com.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ResourceInprovement {

	public static void main(String[] args) throws IOException {

		//JAVA 7
		BufferedReader reader1 = new BufferedReader(new FileReader("text.txt"));
		try (BufferedReader reader2  = reader1){
			System.out.println(reader2.read());
		} 
		
		//JAVA 9
		BufferedReader reader = new BufferedReader(new FileReader(""));
		try(reader){
			System.out.println(reader.read());
		}
	}

}
