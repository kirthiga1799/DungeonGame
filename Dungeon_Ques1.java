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
			
			System.out.println("Enter The Monster Row and Column : ");
			int monsR = sc.nextInt();
			int monsC = sc.nextInt();
			
			int[][] arr = new int[row][col];

        		System.out.println("Enter the number of pits: ");
        		int pits = sc.nextInt();
        		List<int[]> pitList = new ArrayList<>();

        		for (int i = 0; i < pits; i++) {
            		System.out.println("Position of pit " + (i + 1) + " :");
            		int x = sc.nextInt() - 1;
            		int y = sc.nextInt() - 1;
            		pitList.add(new int[]{x, y});
        	}

        	for (int i = advR - 1; i >= goldR - 1; i--) {
           	for (int j = advC - 1; j < col; j++) {
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

        if (arr[goldR - 1][goldC - 1] >= 999)
            System.out.println("No possible solution");
        else
            System.out.println("Minimum number of steps: " + arr[goldR - 1][goldC - 1]);
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
