import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());
        long sum = 0;
        long number = 1;
        long count = 0;

        // 1부터 차례대로 하나씩 더한다.
        // s를 초과하게 되면, 그 때 마지막 두 숫자를 합친다 생각하고 -1해주면 됨
        // n의 최대값은 1부터 차례대로 더하면 나온다.
        // 서로 다른 자연수이므로, 같은 수를 반복해서 쓸 순 없다.
        while (sum < s) {
            sum += number;
            number++;
            count++;
        }

        if (sum > s) {
            System.out.println(count - 1);
        } else if (sum == s) {
            System.out.println(count);
        }
    }
}