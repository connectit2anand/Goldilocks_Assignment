package com.goldilocks;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.goldilocks.exceptions.InvalidRequestException;

public class HashMapProblem {
	
	private static Map<String,Integer> takeInput() throws InvalidRequestException{
		Scanner sc = new Scanner(System.in);
		HashMap<String,Integer> usersInfo = new HashMap<>();
		System.out.println("Please Enter The Number Of Users You Want To Add In The Hash Map");
		int numberOfUsers = sc.nextInt();
		int count = 0;
		while(count < numberOfUsers) {
			
			System.out.println("Please Enter User : " + (count + 1));
			System.out.println("Please Enter The Name");
			
			/*
			 * Converting the name in upperCase so that duplicate name wont be inserted 
			 * with different key for case insensitive
			 */
			String name = sc.next().toUpperCase();
			System.out.println("Please Enter The Age");
			Integer age = null;
			try {
				age = sc.nextInt();
			} catch(InputMismatchException n) {
				throw new InvalidRequestException("Invalid Input. Age should be in Integer");
			}
			if(usersInfo.containsKey(name)) {
				System.out.println("Name " + name + " Already Exist. Age got updated");
				
			} 
			usersInfo.put(name, age);
			count ++;
			
		}	
		return usersInfo;

	}
	
	private static void printUserInfoBasedOnName(Map<String, Integer> usersInfo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter The Use Name Whose Age You Want To See");
		String name = sc.next().toUpperCase();
		if(!usersInfo.containsKey(name)) {
			System.out.println("User with name: " + name + " does not exist");
			return;
		}
		int age = usersInfo.get(name);
		System.out.println(age);
		
	}
	
	private static void printAllUserInfo(Map<String, Integer> usersInfo) {
		Set<Map.Entry<String, Integer>> users = usersInfo.entrySet();
		for(Map.Entry<String, Integer> user : users) {
			System.out.println("Name: " + user.getKey() + " Age: " + user.getValue());
		}
		
	}
	
	public static void main(String[] args) {
		Map<String,Integer> usersInfo = null;
		try {
			usersInfo = takeInput();
		} catch(InvalidRequestException e) {
			System.out.println(e.getMessage());
		}
		if(usersInfo != null) {
			printUserInfoBasedOnName(usersInfo);
			printAllUserInfo(usersInfo);
		}
//		printUserInfoBasedOnName(usersInfo, "manish");
//		printUserInfoBasedOnName(usersInfo, "MaNish");
		
	}

	



	

	
}
