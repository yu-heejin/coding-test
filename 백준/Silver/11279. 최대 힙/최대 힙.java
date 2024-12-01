import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number > 0) {
                maxHeap.add(number);
            } else {
                Integer maxNumber = maxHeap.poll();
                System.out.println(maxNumber == null ? 0 : maxNumber);
            }
        }
    }
}