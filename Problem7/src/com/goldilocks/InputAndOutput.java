package com.goldilocks;

import java.util.Scanner;

public class InputAndOutput {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Give your input to Print");
		System.out.println("To exit type cancel");
		String input;
		while(!(input=sc.nextLine()).equalsIgnoreCase("CANCEL")) {
			System.out.println(input);
		}
	}

}
