package dundeongame;

import java.util.Scanner;

public class Dungeon_Game {

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
			
			
			
			
		System.out.println("Postion of Monster : ");
		int monsR = sc.nextInt();
		int monsC = sc.nextInt();

		System.out.println("Position of Gold : ");
		int goldR = sc.nextInt();
		int goldC = sc.nextInt();

		int[][] arr = new int[row][col];
		System.out.println("Enter the number of pits : ");
		int pit = sc.nextInt();
		List<int[]> pitList = new ArrayList<>();

		for (int i = 0; i < pit; i++) {
			System.out.println("Position of pit " + (i + 1) + " :");
			int pitR = sc.nextInt();
			int pitC = sc.nextInt();
			pitList.add(new int[] { pitR, pitC });
		}

		for (int i = advR - 1; i >= goldR - 1; i--) {
			for (int j = advC; j < col; j++) {
				if (containsPit(pitList, i, j)) {
					arr[i][j] = 999;
					continue;
				}
				if (i == advR - 1 && j == 0)
					continue;
				else if (j == 0)
					arr[i][j] = arr[i + 1][j] + 1;
				else if (i == advR - 1)
					arr[i][j] = arr[i][j - 1] + 1;
				else
					arr[i][j] = Math.min(arr[i + 1][j], arr[i][j - 1]) + 1;
			}
		}

		int monsterMinSteps = Math.abs(monsR - goldR) + Math.abs(monsC - goldC);

		if (monsterMinSteps < arr[goldR - 1][goldC - 1]) {
			System.out.println("No possible solution ");
		} else
			System.out.println("Minimum number of steps : " + arr[goldR - 1][goldC - 1]);
	}

	private static boolean containsPit(List<int[]> pitList, int x, int y) {
		for (int[] pit : pitList) {
			if (pit[0] == x && pit[1] == y) {
				return true;
			}
		}
		return false;
	}
}
