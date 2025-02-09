import java.util.*;
import java.io.*;

// union - find : 사이클 그래프 3개면 발견 못함
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        while (k > 0) {
            String[] input = br.readLine().split(" ");

            int v = Integer.parseInt(input[0]);  // 정점의 개수
            int e = Integer.parseInt(input[1]);  // 간선의 개수

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                input = br.readLine().split(" ");

                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int[] color = new int[v + 1];
            boolean isSuccess = true;
            // 연결되지 않은 그래프도 고려해야함
            for (int i = 1; i <= v; i++) {
                if (!isBipartiteGraph(i, color, graph)) {
                    isSuccess = false;
                    break;
                }
            }

            if (isSuccess) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
            k--;
        }
    }

    private static boolean isBipartiteGraph(int start, int[] color, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];

        q.add(start);

        while (!q.isEmpty()) {
            int current = q.poll();

            if (color[current] == 0) {
                color[current] = 1;
            }
            
            List<Integer> connected = graph.get(current);
            
            for (int c : connected) {
                // 연결된 노드가 이미 칠해져 있는데 같은 색이면 만들 수 없음
                if (color[c] != 0 && color[c] == color[current]) {
                    return false;
                }

                // 연결된 색이 없으면 다른 색으로 칠해준다.
                if (color[c] == 0) {
                    color[c] = color[current] == 1 ? 2 : 1;
                    q.add(c);
                }
            }
        }

        return true;
    }
}