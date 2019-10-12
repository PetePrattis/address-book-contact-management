package mainpackage;

import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Print extends Main{
	public static void show_contacts() throws IOException, FileNotFoundException{
		File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");//we get the cantact file 
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine;
		boolean first = false;
		String[] fields = new String[0];
		while((currentLine = reader.readLine()) !=null) {//for each line in txt file
			if(!first) {//if it is the first line the line is the fields and we save them into an array
				fields = currentLine.split(",");
				first = true;
			}
			else {//for the rest lines we print the information
				System.out.println("-------------------");
				String[] info=currentLine.split(",");
				for (int i = 0; i < fields.length; i++ ) {
					System.out.println(fields[i] +": "+ info[i]);					
				}
			}
		}
		System.out.println("-------------------");
		reader.close();
	}
}
