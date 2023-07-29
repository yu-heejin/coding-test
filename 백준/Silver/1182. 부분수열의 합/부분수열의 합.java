import java.io.*;
import java.util.StringTokenizer;

// 다시 풀어볼 문제
// 등차수열이 아니라 그냥 수열이었음!!!!!!!!!!!!!!
// 조합으로 풀었어도 괜찮았을 것 같다. 부분집합의 개념과 유사하기 때문
public class Main {
    static int answer = 0;
    public static void dfs(int[] numbers, int depth, int sum, int s, int n) {
        // 입력 값으로 받은 수열을 배열로 만들고 순차적으로 탐색
        // 탐색할 때마다 해당 깊이의 값을 포함하고 다음 깊이로 재귀
        // 탐색할 때마다 해당 깊이의 값을 포함하지 않고 다음 깊이로 재귀
        if (depth == n) {   // 깊이가 정수의 개수까지 모두 돌았을 때
            if (sum == s) answer++;  // 그 부분수열의 합이 s와 같으면 정답
            return;
        }
        
        // 1. 해당 깊이의 값을 포함하고 다음 깊이로 재귀
        dfs(numbers, depth + 1, sum + numbers[depth], s, n);
        // 2. 해당 깊이의 값을 포함하지 않고 다음 깊이로 재귀
        dfs(numbers, depth + 1, sum, s, n);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());
        int[] numbers = new int[n];
        
        tokenizer = new StringTokenizer(reader.readLine());
        // 토큰이 다 꺼내진 객체는 재사용이 불가능하며, 새로운 StringTokenizer 객체를 다시 생성
        for (int index=0; index<n; index++) {
            numbers[index] = Integer.parseInt(tokenizer.nextToken());
        }
        // dfs 백트래킹 알고리즘 구현
        // 조건에 충족하지 않으면 이전 깊이로 돌아가 이어서 진행하는 방식
        // 조건은 부분수열의 합(sum)이 s와 같아야한다는 것!
        dfs(numbers, 0, 0, s, n);
        if (s == 0) answer -= 1;   // 공집합의 경우를 하나 빼준다.
        
        writer.write(String.valueOf(answer));
        
        reader.close();
        writer.flush();
        writer.close();
    }
}
