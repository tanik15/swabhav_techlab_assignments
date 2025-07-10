package com.aurionpro.basic.controlstatement;

import java.util.Random;
import java.util.Scanner;

public class PIG {
	private static int score=0;
	private static int runningTheDie(Random random,int generatedNum) {
		generatedNum = random.nextInt(1, 7);
		 if(generatedNum ==1) {
		 System.out.println("Generated num is 1 hence turn terminated");
			 score=0;
			 return generatedNum;
		 }
		 score+=generatedNum;
		 System.out.println("Generated num : "+ generatedNum +"  Score : "+ score+"\n");
		 return generatedNum;
	}
	
	private static void rollADie( int turn) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int generatedNum =0;
		String choice;
		System.out.println("Turn:" + turn);
		while(generatedNum != 1) {
			if(score >19) {
				System.out.println("You win in " + turn + " turn");
				break;
			}
			 System.out.println("Run or Hold (r or h)");
			 choice = scanner.nextLine();
			 
			 if(!choice.equalsIgnoreCase("r"))
				 break;
			 
			generatedNum = runningTheDie(random,generatedNum);
			if(generatedNum==1)
				break;
			 
		};
	}

	public static void main(String[] args) {
		int turn=1;
		while(turn<6) {
			if(score >19) {
				break;
			}
			rollADie(turn);
			turn++;
		}
		if(turn>5 && score<20) {
			System.out.println("Game Over. You loose");
		}
	}

}
