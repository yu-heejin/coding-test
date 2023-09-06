import java.io.*;
import java.util.*;

class Main {
	
	private static final int[] MOVE_X = {0, 0, -1, 1};
	private static final int[] MOVE_Y = {-1, 1, 0, 0};
	private static String[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		String[][] village = new String[n][n];
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			village[i] = br.readLine().split(" ");
		}
		
		int[] counts = new int[31];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				String startCategory = village[i][j];
				if (!visited[i][j]) {
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					int count = 1;
					
					while (!queue.isEmpty()) {
						int[] position = queue.poll();
						for (int l = 0; l < 4; l++) {  // 상하좌우
							int nextX = position[0] + MOVE_X[l];
							int nextY = position[1] + MOVE_Y[l];
							
							if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
								continue;
							}
							
							if (village[nextX][nextY].equals(startCategory) && !visited[nextX][nextY]) {
								queue.add(new int[] { nextX, nextY });
								visited[nextX][nextY] = true;
								count++;
							}
						}
					}
					
					if (count >= k) {
						counts[Integer.parseInt(startCategory)]++;
					}
				}
			}
		}
		
		int maxCount = 0;
		int maxCategory = 0;
		for (int i = 1; i <= 30; i++) {
			if (maxCount < counts[i]) {
				maxCount = counts[i];
				maxCategory = i;
			} else if (maxCount == counts[i] && maxCategory < i) {
				maxCategory = i;
			}
		}
		
		System.out.println(maxCategory);
	}
}
