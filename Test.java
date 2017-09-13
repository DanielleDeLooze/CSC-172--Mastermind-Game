/*
 * Author: Danielle DeLooze
 * Student ID: 29493487
 * Project: Project 1 MasterMind
 */

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int  positions;
		int temp;
		boolean gameState = true;
		boolean playAgain = true;
		MasterMind test;
		
		System.out.println("Hello! Let's play a game of Mastermind!");
		System.out.println("You'll provide the code and I'll break it");
		
		while(playAgain){
		gameState = true;
		System.out.println("How many colors would you like?");
		temp = scan.nextInt();
		System.out.println("How many positions would you like the code to have?");
		positions = scan.nextInt();
		String[] tokenColors = new String[temp];
		System.out.println("Ok, now what are the colors you'd like to use?");
		for(int i =0; i<temp; i++){
			tokenColors[i] = scan.next();
		}
		
		
		test = new MasterMind(tokenColors, positions);
		
		
			
			while(gameState){
				test.nextMove();
				System.out.println("Is "+Arrays.toString(test.guess)+" the right code?");
				System.out.println("How many colors are in the correct positions?");
				int right = scan.nextInt();
				System.out.println("How many colors are in the wrong spot, but are the correct color?");
				int mix = scan.nextInt();
				test.response(right, mix);
				if (right == positions && mix == 0){
					gameState = false;
					System.out.println("Hooray! I figured it out!");
					System.out.println("Would you like to play again?");
					System.out.println("If yes, type 'Yes'. If no, type 'No'");
					String newGame = scan.next();
					if (newGame.equals("Yes")){
						test.newGame();
					}
					else if(newGame.equals("No")){
						playAgain = false;
						System.out.println("Thanks for playing!");
					}
				}
				
			
			}
		}
			
	}
}
