package com.rao.System.Assignment;

import java.util.Scanner;

public class countVowel {

	public static void main(String[] args) {

		Scanner ctr = new Scanner(System.in);
		int totVowel= 0 ;
		String response = "Y", str;
		while (response.equals("Y")){
			System.out.println("Enter the String ");
			str = ctr.nextLine();
			totVowel = countVowl(str);
			System.out.println("Number of the given vowel in the sentence : "+ totVowel);
			System.out.println(" \nAnymore want to check vowel in the sentence ");
			response = ctr.nextLine();
		}
	}
	// To count number of Vowel in sentence
	private static int countVowl(String str) {
		int count = 0;
		for(int i= 0; i<str.length();i++) {
			char ch = str.charAt(i);
			 if(ch == 'a' || ch == 'A' ||
				ch == 'e' || ch == 'E' ||
				ch == 'i' || ch == 'I' ||
				ch == 'o' || ch =='O'  ||
				ch == 'u' || ch == 'U' ){
		            count ++;
			 }      
		}
		return count;
	}
}
