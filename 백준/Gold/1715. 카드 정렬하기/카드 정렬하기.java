import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int N = Integer.parseInt(br.readLine());
      
      if (N == 1) {
          // N == 1이면 비교할 필요가 없으므로 0
          System.out.println(0);
      } else {
      
          PriorityQueue<Integer> cards = new PriorityQueue<>();
          
          // 가장 작은 수끼리 먼저 더해준다.
          for (int i = 0; i < N; i++) {
              cards.add(Integer.parseInt(br.readLine()));
          }
          
          int answer = 0;
          
          while (cards.size() > 1) {
              int card1 = cards.poll();
              int card2 = cards.poll();
              
              int sum = card1 + card2;
              
              if (cards.size() > 0) {
                  cards.add(sum);
              }
              answer += sum;
          }
          
          if (cards.size() == 1) {
              answer += cards.poll();
          }
          System.out.println(answer);
      }
  }
}