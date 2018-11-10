package chapter18.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuffedInputFile {
	
	public static String read(String fileName) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String s;
		StringBuilder sb = new StringBuilder();
		while( (s = in.readLine()) != null)
			sb.append(s + "\n");
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException{
		System.out.println(new File("Fill.java").getAbsolutePath());
		System.out.println(read("Fill.java"));
	}
}
