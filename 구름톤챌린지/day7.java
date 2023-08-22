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
		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().split(" ");
		}
		
		int[] flagCount = new int[9];   // k는 1부터 8까지
		Arrays.fill(flagCount, 0);
		
		for (int i = 0; i < n; i++) {   // row
			for (int j = 0; j < n; j++) {   // col
				int count = 0;
				if (board[i][j].equals("1")) {
					continue;
				}
				// 상
				if (i > 0 && board[i-1][j].equals("1")) {
					count++;
				}
				// 하
				if (i < n - 1 && board[i+1][j].equals("1")) {
					count++;
				}
				// 좌
				if (j > 0 && board[i][j-1].equals("1")) {
					count++;
				}
				// 우
				if (j < n - 1 && board[i][j+1].equals("1")) {
					count++;
				}
				// 왼쪽 위 대각선
				if (i > 0 && j > 0 && board[i-1][j-1].equals("1")) {
					count++;
				}
				// 오른쪽 위 대각선
				if (i > 0 && j < n - 1 && board[i-1][j+1].equals("1")) {
					count++;
				}
				// 왼쪽 아래 대각선
				if (i < n - 1 && j > 0 && board[i+1][j-1].equals("1")) {
					count++;
				}
				// 오른쪽 아래 대각선
				if (i < n - 1 && j < n - 1 && board[i+1][j+1].equals("1")) {
					count++;
				}
				
				flagCount[count]++;
			}
		}
		
		System.out.println(flagCount[k]);
	}
}
