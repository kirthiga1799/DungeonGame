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
 int[][] stepsArray = new int[row][col];

        for (int i = advR - 1; i >= goldR - 1; i--) {
            for (int j = advC; j < col; j++) {
                if (containsPit(pitList, i, j) || (i == triggerR - 1 && j == triggerC - 1)) {
                    stepsArray[i][j] = 999;
                    continue;
                }
                if (i == advR - 1 && j == 0)
                    continue;
                else if (j == 0)
                    stepsArray[i][j] = stepsArray[i + 1][j] + 1;
                else if (i == advR - 1)
                    stepsArray[i][j] = stepsArray[i][j - 1] + 1;
                else
                    stepsArray[i][j] = Math.min(stepsArray[i + 1][j], stepsArray[i][j - 1]) + 1;
            }
        }

        int monsterMinSteps = Math.abs(monsR - triggerR) + Math.abs(monsC - triggerC);
        int triggerToGoldSteps = Math.abs(triggerR - goldR) + Math.abs(triggerC - goldC);

        int totalSteps = stepsArray[monsR - 1][monsC - 1] + monsterMinSteps + triggerToGoldSteps;

        System.out.println("Minimum number of steps: " + totalSteps);
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
