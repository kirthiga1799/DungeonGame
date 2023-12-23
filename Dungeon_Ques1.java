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

			int adventureMinimumSteps = Math.abs(advR - goldR) + Math.abs(advC - goldC);
			int monsterMinimumSteps = Math.abs(monsR - goldR) + Math.abs(monsC - goldC);
			
			if (adventureMinimumSteps > monsterMinimumSteps)
				System.out.println("No possible solution");
			else {
				System.out.println("Minimum number of steps is  : " + adventureMinimumSteps);
				System.out.println("Path : " );
				for (int i = advR; i >= goldR; i--) {
					for (int j = advC; j <= goldC; j++) {
						System.out.print("(" + i + "," + j + ")");
						if (i != goldR || j != goldC)
							System.out.print("->");
				}
				advC = goldC;
			}

		}

		}

	}

