import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        // 투 포인터를 사용하기 위한 정렬
        Arrays.sort(numbers);

        int x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = n - 1;
        int answer = 0;

        // <= 는 안됨, 두 수여야함
        while (left < right) {
            int first = numbers[left];
            int second = numbers[right];

            if (first + second == x) {
                answer++;
                left++;   // right++ 도 가능
            } else if (first + second > x) {
                // 크면 오른쪽 값을 줄인다.
                right--;
            } else if (first + second < x) {
                // 작으면 왼쪽 값을 늘린다.
                left++;
            }
        }

        System.out.println(answer);
    }
}