import java.util.Scanner;
import java.util.Arrays;

public class Main {
    // 다시 풀어볼 문제
    static int answer = Integer.MAX_VALUE;
    static void calculateScore(int[][] s, int n, boolean[] visited) {
        // 방문한 팀을 스타트팀이라고 가정한다.
        int[] scores = {0, 0};
        
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (visited[i] && visited[j]) {
                    // 만약 스타트팀이라면
                    scores[0] += (s[i][j] + s[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    // 링크팀이라면 (방문x)
                    scores[1] += (s[i][j] + s[j][i]);
                }
            }
        }
        
        int calculateResult = Math.abs(scores[0] - scores[1]);
        if (calculateResult == 0) {   // 두 팀의 합의 차가 0이면 최소값
            answer = calculateResult;
            return;
        }
        
        answer = Math.min(calculateResult, answer);
    }
    
    public static void combinationTeam(int[][] s, int n, boolean[] visited, int r, int start) {
        if (r == n / 2) {   // base case
            calculateScore(s, n, visited);   // n/2명 뽑았으면 구하며 최솟값찾기
            // 따로 반복을 돌릴필요 없이 계속 재귀가 돌기 때문에 최소값을 찾을 수 있음
            return;
        }
        
        for (int i=start; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combinationTeam(s, n, visited, r + 1, i + 1);
                visited[i] = false;   // 재귀가 끝나면 다시 비방문으로 변경
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] s = new int[n][n];
        boolean[] visited = new boolean[n];  // 방문 여부
        
        Arrays.fill(visited, false);
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        
        combinationTeam(s, n, visited, 0, 0);
        System.out.println(answer);        
        sc.close();
    }
}