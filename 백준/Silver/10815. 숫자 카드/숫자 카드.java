import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Integer> numbers = new HashSet<>();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        int m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < m; i++) {
            int other = Integer.parseInt(input[i]);

            // 시간 복잡도 O(n)
            // if (numbers.indexOf(other) != -1) {
            //     answer.append("1 ");
            // } else {
            //     answer.append("0 ");
            // }

            // 시간 복잡도 O(1)
            if (numbers.contains(other)) {
                answer.append("1 ");
            } else {
                answer.append("0 ");
            }
        }

        System.out.println(answer.toString());
    }
}