import java.io.*;
import java.util.*;

// 이어진 값만 확인하면 최소 개수를 구할 수 있음
class Main {
	
	// 상하좌우
	private static final int[] MOVE_X = {0, 0, -1, 1};
	private static final int[] MOVE_Y = {-1, 1, 0, 0};
	
	private static String[][] village;
	private static boolean[][] visited;
	private static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		village = new String[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			village[i] = br.readLine().split(" ");
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 재귀로는 런타임 에러 발생
				if (village[i][j].equals("1") && !visited[i][j]) {
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					
					while (!queue.isEmpty()) {
						int[] position = queue.poll();
						for (int k = 0; k < 4; k++) {  // 상하좌우
							int nextX = position[0] + MOVE_X[k];
							int nextY = position[1] + MOVE_Y[k];
							
							if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
								continue;
							}
							
							if (village[nextX][nextY].equals("1") && !visited[nextX][nextY]) {
								queue.add(new int[] { nextX, nextY });
								visited[nextX][nextY] = true;
							}
						}
					}
					
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
