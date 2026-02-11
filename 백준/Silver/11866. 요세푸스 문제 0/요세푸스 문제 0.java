import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[n];
        int num = 0;
        int count = 0;
        List<Integer> answers = new ArrayList<>();

        while (!isFinished(visited)) {
            if (!visited[num]) {
                count++;
            }

            if (count == k) {
                count = 0;
                visited[num] = true;
                answers.add(num + 1);
            }
            
            num = (num + 1) % n;
        }

        System.out.print("<");
        for (int i = 0; i < answers.size(); i++) {
            System.out.print(answers.get(i));
            if (i < answers.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.print(">");
            }
        }
    }

    private static boolean isFinished(boolean[] visited) {
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}