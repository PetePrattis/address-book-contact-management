package mainpackage;

import java.util.Arrays;
import java.util.Scanner;

import mainpackage.Print;
import mainpackage.Add;
import mainpackage.Search;
import mainpackage.Change;
import mainpackage.Delete;

import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.charset.Charset;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		int exit = 0;
		int answer;
		//we will loop until user wants to exit the application
		do {
			System.out.println("--------Welcome to Address Book---------");
			System.out.println("Enter '1' to Add contact");
			System.out.println("Enter '2' to Search contact");
			System.out.println("Enter '3' to Print contact");
			System.out.println("Enter '4' to Edit contact");
			System.out.println("Enter '5' to Delete contact");
			System.out.println("Enter '0' to Exit");
			System.out.println("Do you want to print contacts, add contact, search for contact, edit contact or delete contact?");
			System.out.println("Answer with '1', '2', '3', '4', '5' or '0' to exit application.");	
			try {//we handle the input of the user
				answer = input.nextInt();
			} catch (NumberFormatException e) {
			    //e.printStackTrace();
				answer = -1;
			}
			if(answer == 1)//according to user's input we go to each class
				
				Add.add_contact();
			else if(answer == 2)
				Search.choose_field();
			else if(answer == 3)
				Print.show_contacts();
			else if(answer == 4)
				Change.choose_field();
			else if(answer == 5)
				Delete.choose_field();
				
			
		}while(answer != exit);
		System.out.println("Application terminating...");
	}
}
