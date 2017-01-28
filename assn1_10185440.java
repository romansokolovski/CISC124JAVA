//ROMAN SOKOLOVSKI
//10185440
//ASSIGNMENT 1 CISC124


package cisc124;


import java.util.Random;
import java.util.Scanner;

public class assn1_10185440{
	static Random generator1 = new Random(System.currentTimeMillis());
	static Scanner scanner = new Scanner(System.in);
	
	
	public static int getNums(){ //Returns randomly generated numbers
		int n1 = generator1.nextInt(6)+1;
		return n1;	
	}
	
	public static String convertNums(int n){ //converts to numbers to the word 
		if (n==1){
			String s = "One";
			return s;
		}else if (n==2){
			String s = "Two";
			return s;
		}else if (n==3){
			String s = "Three";
			return s;
		}else if (n==4){
			String s = "Four";
			return s;
		}else if (n==5){
			String s = "Five";
			return s;
		}else{
			String s ="Six";
			return s;
		}		
	}
	
	public static void playerRoll(int playerScore, int cpuScore, int totalScore){ //method controls players turn
		int playerTotal = playerScore;
		int cpuTotal = cpuScore;
		int turnScore = totalScore;
		
		boolean valid = true;
		while (valid == true){
		int dice1 = getNums();
		int dice2 = getNums();
		System.out.println("Player rolls: "+ convertNums(dice1)+ " + "+ convertNums(dice2));
		
		if (dice1+dice2 <= 2){ //if both dice are 1, turn is over total/turn score set to 0
			System.out.println("Players turn is over, total score set to 0 for the turn");
			System.out.println(" ");
			turnScore = 0;
			playerTotal = 0;
			cpuRoll(playerTotal, cpuTotal, turnScore);
			valid = false;
			
		}else if( dice1 ==  1 || dice2 == 1){//if one of the dice =1 then turn score set to 0, and turn is over
			System.out.println("Players turn is over, turn score set to 0 for the turn");
			System.out.println(" ");
			playerTotal = playerTotal-turnScore;
			turnScore = 0;
			cpuRoll(playerTotal, cpuTotal, turnScore);
			valid = false;

		}else if(dice1 == dice2 && dice1 !=1 && dice2 !=1){//if dice match, redo turn
			System.out.println("Dice Match!, player must roll again");
			System.out.println(" ");
			playerRoll(playerTotal, cpuTotal, turnScore);
				
		}else if (playerTotal >=100 || cpuTotal >=100){//if score reaches 100 game is over
			System.out.println("Game Over");
			if (playerTotal>cpuTotal){
				System.out.println("player wins!! Total: "+playerTotal);	
			}else{
				System.out.println("CPU wins!");
			}
			System.out.println("Play again?(y/n)");
			String ans = scanner.nextLine();
			switch (ans) {//asks user if they want to play again, prevents invalid characters 
            case "y": playerRoll(0, 0, 0);
            case "n": System.out.println("Thanks for playing");
                       break;          
            default: System.out.println("Invalid char, try again");
                     scanner.nextLine();                      
			}
		}
			
			else{                                             //adds to the two dice to turnscore and total score
			System.out.println("Player rolled: "+convertNums(dice1)+" and "+convertNums(dice2));
			System.out.println("Score added to total!");
			turnScore = turnScore + dice1 + dice2;
			playerTotal = playerTotal + dice1 + dice2;
			System.out.println("Players total= "+playerTotal+" CPU Total= "+cpuTotal);
			System.out.println(" ");
			System.out.println("Roll again?(y/n)");
			String answer = scanner.nextLine();
			
			switch (answer) {//asks user if they want to roll again, prevents invalid characters 
            case "y": playerRoll(playerTotal, cpuTotal, turnScore);
            case "n": turnScore = 0;
			          cpuRoll(playerTotal, cpuTotal, turnScore);
            default: System.out.println("Invalid char, try again");
                     scanner.nextLine();                      
			}			
		}
		}	
	}
	
	
	public static void cpuRoll(int playerScore, int cpuScore, int totalScore){//controls the computers turn
		int playerTotal = playerScore;
		int cpuTotal = cpuScore;
		int turnScore = totalScore;
	
		
		boolean valid = true;
		while(valid == true){
		int dice1 = getNums();
		int dice2 = getNums();
		System.out.println(" ");
		System.out.println("CPU rolls: "+ convertNums(dice1)+ " + "+ convertNums(dice2));
		
		if (dice1+dice2 <= 2){//if both dice are 1, turn is over total/turn score set to 0
			System.out.println("CPU turn is over, total score set to 0 for the turn");
			System.out.println(" ");
			cpuTotal = 0;
			turnScore = 0;
			playerRoll(playerTotal, cpuTotal, turnScore);
			valid = false;
			
		}else if( dice1 ==  1 || dice2 == 1){//if one of the dice =1 then turn score set to 0, and turn is over
			System.out.println("CPU turn is over, turn score set to 0 for the turn");
			System.out.println(" ");
			cpuTotal = cpuTotal-turnScore;
			turnScore = 0;
			playerRoll(playerTotal, cpuTotal, turnScore);
			valid = false;

		}else if(dice1 == dice2 && dice1 !=1 && dice2 !=1){//if dice match, redo turn
			System.out.println("Dice Match!, CPU must roll again");
			System.out.println(" ");
			cpuRoll(playerTotal, cpuTotal, turnScore);
					
		}else if (playerTotal >=100 || cpuTotal >=100){//if score reaches 100 game is over
			System.out.println("Game Over");
			if (playerTotal>cpuTotal){
				System.out.println("player wins!! Total: "+playerTotal);	
			}else{
				System.out.println("CPU wins!");

			}
			System.out.println("Play again?(y/n)");
			String ans = scanner.nextLine();
			switch (ans) {//asks user if they want to play again, prevents invalid characters 
            case "y": playerRoll(0, 0, 0);
            case "n": System.out.println("Thanks for playing");
                       break;          
            default: System.out.println("Invalid char, try again");
                     scanner.nextLine();                      
			
			}
		}else{                                          //adds to the two dice to turnscore and total score
			System.out.println("CPU rolled: "+convertNums(dice1)+" and "+convertNums(dice2));
			System.out.println("Score added to total!");
			turnScore = turnScore + dice1 + dice2;
			cpuTotal = cpuTotal + dice1 + dice2;
			System.out.println("Player Total= "+playerTotal+"CPU Total= "+cpuTotal);
			System.out.println("CPU rolls again");
			cpuRoll(playerTotal, cpuTotal, turnScore);	
		}
		}
	}
	
	public static void main(String args[]){
		System.out.println("Welcome to PIG");
		System.out.println("Player Starts");
		int playerTotal = 0;
		int cpuTotal = 0;
		int turnScore = 0;
		playerRoll(playerTotal,cpuTotal,turnScore);
			
	}

}
