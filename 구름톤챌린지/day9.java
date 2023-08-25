import java.io.*;
import java.util.*;

class Main {
	
	private static String[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		String[][] board = new String[n][n];
		int[][] score = new int[n][n];
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				score[i][j] = 0;
			}
		}
		
		// 상하좌우
		int[] moveY = {0, 0, -1, 1};
		int[] moveX = {-1, 1, 0, 0};
		for (int i = 0; i < k; i++) {
			input = br.readLine().split(" ");
			int y = Integer.parseInt(input[0]) - 1;
			int x = Integer.parseInt(input[1]) - 1;
			
			if (board[y][x].equals("0")) {
				score[y][x]++;
			} else if (board[y][x].equals("@")) {
				score[y][x] += 2;
			}
			
			for (int j = 0; j < 4; j++) {
				int nextY = y + moveY[j];
				int nextX = x + moveX[j];
				
				if (isBound(nextY, nextX, n)) {
					if (board[nextY][nextX].equals("0")) {
						score[nextY][nextX]++;
					} else if (board[nextY][nextX].equals("@")) {
						score[nextY][nextX] += 2;
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (max < score[i][j]) {
					max = score[i][j];
				}
			}
		}
		
		System.out.println(max);
	}
	
	private static boolean isBound(int y, int x, int n) {
		if (y < 0 || x < 0 || y >= n || x >= n) {
			return false;
		}
		
		return true;
	}
}
