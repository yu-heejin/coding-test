import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        List<Integer> belt = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();

        for (int i = 0; i < 2 * n; i++) {
            belt.add(Integer.parseInt(input[i]));
            visited.add(false);
        }

        int step = 0;
        
        while (true) {
            step++;
            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            Collections.rotate(belt, 1);
            Collections.rotate(visited, 1);
            
            // 내릴 수 있는 위치면 즉시 내린다.
            if (visited.get(n - 1)) {
                visited.set(n - 1, false);
            }

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다.
            // 로봇의 이동은 뒤에서부터 해야한다!!! 안 그러면 이동에 제약걸림
            // n-2부터 시작하는 이유는, n-1이면 내려야하기 때문
            for (int i = n - 2; i >= 0; i--) {
                int current = i;
                int next = i + 1;
                
                // 이동하려는 칸에 로봇이 없고, 내구도가 1 이상 남아있어야 한다.
                // belt.get(next) > 1로 해서 틀림..
                if (visited.get(current) && belt.get(next) >= 1 && !visited.get(next)) {
                    visited.set(current, false);
                    visited.set(next, true);
                    belt.set(next, belt.get(next) - 1);

                    if (visited.get(n - 1)) {
                        visited.set(n - 1, false);
                    }
                }
            }

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if (belt.get(0) > 0 && !visited.get(0)) {
                visited.set(0, true);
                belt.set(0, belt.get(0) - 1);
            }

            // 내구도 0인 칸의 개수
            // 처음에 k-- 직접 했더니 중복으로 감소돼서 반복문이 빨리 끝남
            int zeroCount = 0;
            for (int durability : belt) {
                if (durability == 0) zeroCount++;
            }

            if (zeroCount >= k) break;
        }

        System.out.println(step);
    }
}