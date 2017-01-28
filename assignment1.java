package cisc124;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;


public class assignment1 {
	
	static int playerTotal = 0;
	static int cpuTotal = 0;
	static Random generator1 = new Random(System.currentTimeMillis());
	static Scanner scanner = new Scanner(System.in);
	
	public static int getNums(){
		int n1 = generator1.nextInt(6)+1;
		return n1;
		
	}
	
	
	//SHIT DOESNT RETURN NEW NUMS EACH ROLL, FIX THAT SHIT, MAKE MORE METHODS, make a turn score
	//use OBJECTS
	
	public static void rollPlayer(){
		
		int dice1 = getNums();
		int dice2 = getNums();
		boolean valid = true;
		
		while (valid == true){
			
		
		System.out.println("Player rolls: "+ dice1+ " + "+ dice2);
		if (dice1+dice2 <= 2){
			System.out.println("Players turn is over, total score set to 0 for the turn");
			playerTotal = 0;
			valid = false;
			
		}if( dice1 ==  1 || dice2 == 1){
			System.out.println("Players turn is over, turn score set to 0 for the turn");
			valid = false;

		}if(dice1 == dice2 && dice1 !=1 && dice2 !=1){
			System.out.println("Dice Match!, player must roll again");
			//shit here
			
		}else{
			
			System.out.println("Score added to total!");
			playerTotal = playerTotal + dice1 + dice2;
			System.out.println("Players total= "+playerTotal+"CPU Total= "+cpuTotal);

			System.out.println("Roll again?(y/n)");
			String answer = scanner.nextLine();
			if (answer == "y"){
				dice1 = 0;
				dice1 = getNums();
				dice2 = 0;
				dice2 = getNums();
				rollPlayer();
			}else{
				
				rollCPU();
			}
			
			
		}
		
		}
		
	}
	
	public static void rollCPU(){
		
		
		
		
	}
	

	public static void main(String[] args) {
		System.out.println("Welcome to PIG");
		System.out.println("Player Starts");
		rollPlayer();
		
	
		
		

	}

}
