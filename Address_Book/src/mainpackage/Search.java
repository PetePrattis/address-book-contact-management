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


public class Search {
	public static void choose_field() throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		int exit = 0;
		int answer;
		//we will loop until user wants to exit the application
		do {
			System.out.println("Do you want to search beased on name or based on phone?");
			System.out.println("Give '1' or '2' or anser '0' to return to main menu.");	
			try {
				answer = input.nextInt();
			} catch (Exception e) {
				answer = 0;
			}
			if(answer == 1)//according to user's input i go to the correct method
				name_search();
			else if(answer == 2)
				number_search();
							
		}while(answer != exit);
	}
	
	public static void name_search() throws IOException, FileNotFoundException{
		Scanner input= new Scanner(System.in);
		String f1,f2;
		System.out.println("Give Name: ");
		f1 = input.nextLine();
		System.out.println("Give Surname: ");
		f2 = input.nextLine();
		File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine;
		boolean first = false;
		String[] fields = new String[0];
		while((currentLine = reader.readLine()) !=null) {
			if(!first) {
				fields = currentLine.split(",");
				first = true;
			}
			else {//if both fields that the user gave match a contact i show contact's info
				String[] info=currentLine.split(",");
				if(info[0].equals(f1) && info[1].equals(f2)) {
					System.out.println("----There is a contact for the information you gave----");
					for (int i = 0; i < fields.length; i++ ) {
						System.out.println(fields[i] +": "+ info[i]);					
					}
				}
				else if(info[0].equals(f1) && !info[1].equals(f2)) {//if one of the fields that the user gave match a contact i show contact's info
					System.out.println("----There is a contact for the Name you gave----");
					for (int i = 0; i < fields.length; i++ ) {
						System.out.println(fields[i] +": "+ info[i]);					
					}
				}
				else if(!info[0].equals(f1) && info[1].equals(f2)) {//if one of the fields that the user gave match a contact i show contact's info
					System.out.println("----There is a contact for the Surname you gave----");
					for (int i = 0; i < fields.length; i++ ) {
						System.out.println(fields[i] +": "+ info[i]);					
					}
				}
				
			}
		}
		System.out.println("-------------------");
		reader.close();
		choose_field();
	}
	
	public static void number_search() throws IOException, FileNotFoundException{
		Scanner input= new Scanner(System.in);
		int f1 = -1;
		int f2 = -1;
		boolean valid;
		System.out.println("Give Phone number: ");
		do {//this is a do-while loop in which I check for valid input (must me integer)
			valid = true;
			try {
			    f1 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
			    //e.printStackTrace();
				System.out.println("Phone number must be number.");
				valid = false;
			}
		}while(valid == false);
		System.out.println("Give mobile number: ");
		do {
			valid = true;
			try {
			    f2 = Integer.parseInt(input.nextLine());
			} catch (NumberFormatException e) {
			    //e.printStackTrace();
				System.out.println("Mobile number must be number.");
				valid = false;
			}
		}while(valid == false);
		File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine;
		boolean first = false;
		String[] fields = new String[0];
		if(f1 == -1 && f2 == -1) {
			System.out.println("-------------------");
			System.out.println("You gave wrong information.");
		}
		else {
			while((currentLine = reader.readLine()) !=null) {
				if(!first) {
					fields = currentLine.split(",");
					first = true;
				}
				else {//if any of the user's inputs match a contact i show the contact's info
					String[] info=currentLine.split(",");
					if(f1 == -1 && f2 != -1) {
						if(info[3].equals(String.valueOf(f2))) {
							System.out.println("----There is a contact for the Mobile number you gave----");
							for (int i = 0; i < fields.length; i++ ) {
								System.out.println(fields[i] +": "+ info[i]);					
							}
						}
					}
					else if(f1 != -1 && f2 == -1) {
						if(info[2].equals(String.valueOf(f1))) {
							System.out.println("----There is a contact for the Phone number you gave----");
							for (int i = 0; i < fields.length; i++ ) {
								System.out.println(fields[i] +": "+ info[i]);					
							}
						}
					}
					else if (f1 != -1 && f2 != -1) {
						if(info[2].equals(String.valueOf(f1)) && info[3].equals(String.valueOf(f2))) {
							System.out.println("----There is a contact for the Phone and Mobile number you gave----");
							for (int i = 0; i < fields.length; i++ ) {
								System.out.println(fields[i] +": "+ info[i]);					
							}
						}
						else if(info[2].equals(String.valueOf(f1)) && !info[3].equals(String.valueOf(f2))) {
							System.out.println("----There is a contact for the Phone number you gave----");
							for (int i = 0; i < fields.length; i++ ) {
								System.out.println(fields[i] +": "+ info[i]);					
							}
						}
						else if(!info[2].equals(String.valueOf(f1)) && info[3].equals(String.valueOf(f2))) {
							System.out.println("----There is a contact for the Phone number you gave----");
							for (int i = 0; i < fields.length; i++ ) {
								System.out.println(fields[i] +": "+ info[i]);					
							}
						}
					}					
				}			
			}
		}
		
		System.out.println("-------------------");
		reader.close();
		choose_field();
	}


}
