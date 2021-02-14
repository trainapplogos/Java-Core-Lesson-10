package ua.lviv.trainapplogos;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		/* ------[ Task1 ]------ */
		Scanner sc = new Scanner(System.in);
		System.out.println("[Task 1:]");
		System.out.println("> Enter word to check for palindrome:");
		StringBuffer sb = new StringBuffer(sc.nextLine());
		
		if (sb.length() <= 5) {
			if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
				System.out.println("> Entered word is palindrome");
			} else {
				System.out.println("> Entered word isn't palindrome");
			}
		} else System.out.println("> This word contains more than 5 characters");
		System.out.println("__________________________________________________________");
		
		/* ------[ Task2 ]------ */
		System.out.println("\n[Task 2:]");
		System.out.println("> Enter new string:");
		
		String row = sc.nextLine();
		sb = new StringBuffer(row);
		
		if (row.length() == 0) {
			System.out.println("> Error: You didn't enter any words. \nExit...");
			return;
		}
		
		/* by StringBuffer */
		for (int i = 0; i < row.length(); i++) {
			char ch = sb.charAt(i);
					
			if ((ch == 'a') || (ch == 'e') || (ch == 'y') || (ch == 'u') || (ch == 'i') || (ch == 'o') ||
				(ch == 'à') || (ch == 'î') || (ch == 'ó') || (ch == 'è') || (ch == '³') || (ch == '¿')	|| (ch == 'å')) {
				sb.setCharAt(i, '-');
			}
		}
		System.out.println("> String with vowels changed to '-':");
		System.out.println(sb);
		System.out.println("__________________________________________________________");
		sc.close();
		
		/* ------[ Task 3 ]------ */
		String [] wordsArray; // array of all words
		String [] trueWordsArray; //array of true words like those which has more than 5 letters, without empty words
		wordsArray = row.split(" "); //parse array by space char
		
		//int wordsCount = wordsArray.length; //Count of words in row
		int trueWords = 0; //counter for true words
		
		trueWordsArray = wordsArray; //copy
		
		for (int i = 0; i < wordsArray.length; i++) {
			String word = wordsArray[i].trim();
			if (word.length() > 2) {	
				trueWordsArray[trueWords] = word;
				trueWords++; // do not take into account empty words from spaces only
							 // like "hello are we true   people  say him   "
			}
		}
		
		System.out.println("\n[Task 3:]");
		
		if (trueWords > 1) { 
			System.out.println("> There are " + trueWords + " true words"); 
		} else {
			System.out.println("> There is " + trueWords + " true word"); 
		}
		System.out.println("__________________________________________________________");
		
		/* ------[ Task 4 ]------ */
		int arrcount [] = new int[trueWords];

		Arrays.fill(arrcount, 1); // fill array by 1 to take into account base word of comparing
		
		for (int i = 0; i < trueWords; i++) {
			for (int j = i + 1; j < trueWords; j++) {
				if (trueWordsArray[i].equalsIgnoreCase(trueWordsArray[j])) arrcount[i]++;
			}
		}
		
		/* find maximum value of array with word's count */
		int max = 0;
		int maxInd = 0;
		
		for (int i = 0; i < trueWords; i++) {
			if (max < arrcount[i]) { 
				max = arrcount[i];
				maxInd = i;
			}
		}
		System.out.println("\n[Task 4:]");
		System.out.println("> The most frequent word is '" + trueWordsArray[maxInd] + "'. \nIt occurs " + arrcount[maxInd] + " times");
		
		//array = Arrays.copyOf(arr, i + 1);
		
	}
}
