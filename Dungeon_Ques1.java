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
			
			int minimumSteps = Math.abs(goldR - advR) + Math.abs(advC - goldC);
			System.out.println("Minimum number of steps is  : " + minimumSteps);
		}

	}

