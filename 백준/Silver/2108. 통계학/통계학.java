import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
        }
        
        Arrays.sort(numbers);

        // 1. 산술평균 출력 - 소수점 이하 첫째자리에서 반올림한 값을 출력
        System.out.println((int) Math.round((double) sum / N));

        // 2. 중앙값
        System.out.println(numbers[N / 2]);

        // 3. 최빈값
        int maxCount = 0;  // 이 값을 1로 두지 않는 이유는 각 원소가 하나씩만 있는 경우를 고려
        int count = 1;
        int maxNumber = numbers[0];
        boolean isNext = false;    // 두번째로 작은 값인가요?
        for (int i = 0; i < N - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                count++;
            } else {
                // 여러개 값이 있는 경우 두번째로 작은 값을 출력한다.
                if (maxCount < count) {
                    maxCount = count;
                    maxNumber = numbers[i];
                    isNext = false;
                } else if (maxCount == count && !isNext) {
                    maxNumber = numbers[i];
                    isNext = true;
                }
                count = 1;
            }
        }

        // 마지막 숫자에 대한 최빈값
        if (maxCount < count) {
            maxNumber = numbers[N - 1];
        } else if (maxCount == count && !isNext) {
            maxNumber = numbers[N - 1];
        }

        System.out.println(maxNumber);

        // 4. 범위
        System.out.println(numbers[N - 1] - numbers[0]);
    }
}