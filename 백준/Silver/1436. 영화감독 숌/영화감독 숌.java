import java.util.*;
import java.io.*;

// 미리 수를 찾아서 배열에 저장하면 메모리 초과 발생
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer number = 666;
        int count = 0;

        while (count <= N) {
            String n = number.toString();

            if (n.contains("666")) {
                count++;
            }

            if (count == N) {
                System.out.println(number);
                break;
            }

            number++;
        }
    }
}