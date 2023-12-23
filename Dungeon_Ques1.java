package dundeongame;

import java.util.Scanner;

public class Dungeon_Ques1 {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter The Row And Column :  ");
			int row = sc.nextInt();
			int col = sc.nextInt();

			System.out.println("Enter The Adventure Row And Column : ");
			int advR = sc.nextInt();
			int advC = sc.nextInt();

			System.out.println("Enter The Gold Row and Column : ");
			int goldR = sc.nextInt();
			int goldC = sc.nextInt();
			
			System.out.println("Enter The Monster Row and Column : ");
			int monsR = sc.nextInt();
			int monsC = sc.nextInt();
			System.out.println("Position of Trigger : ");
			int trigR = sc.nextInt(); 
			int trigC = sc.nextInt();
		
		
			int adventureMinimumSteps = Math.abs(advR - goldR) + Math.abs(advC - goldC);
			int monsterMinimumSteps = Math.abs(monsR - goldR) + Math.abs(monsC - goldC);

			if (adventureMinimumSteps > monsterMinimumSteps) {
				int advTrig = Math.abs(advR - trigR) + Math.abs(advC - trigC);
				int trigGold = Math.abs(trigR - goldR) + Math.abs(trigC - goldC);
					System.out.println("Minimum number of steps is  : " + (advTrig + trigGold));

			} else {
				System.out.println("Minimum number of steps is  : " + adventureMinimumSteps);

			}
		}

	}

