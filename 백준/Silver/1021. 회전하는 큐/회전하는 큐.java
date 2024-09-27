import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String[] input = br.readLine().split(" ");
      
      int N = Integer.parseInt(input[0]);
      int M = Integer.parseInt(input[1]);
      
      List<Integer> deque = new ArrayList<>();
      
      for (int i = 1; i <= N; i++) {
          deque.add(i);
      }
      
      input = br.readLine().split(" ");
      
      int result = 0;
      
      for (String i : input) {
          int number = Integer.parseInt(i);
          
          // 내가 뽑고자 하는 숫자의 위치
          int requestIndex = deque.indexOf(number);
          
          // 만약 맨 앞에 있는 경우 그냥 삭제한다.
          if (requestIndex == 0) {
              deque.remove(0);
              continue;
          }
          
          // 현재 덱의 크기
          int size = deque.size();
          
          // 내 뒤쪽에 있는 덱 크기
          int afterSize = size - requestIndex - 1;
          
          // 내 앞쪽에 있는 덱 크기
          int beforeSize = requestIndex;
          
          if (afterSize >= beforeSize) {
              // 앞 쪽 덱의 크기가 더 작은 경우, 앞쪽으로 연산 수행
              for (int j = 0; j < beforeSize; j++) {
                  // 앞 쪽에서 뺀 후 뒤로 추가
                  int p = deque.remove(0);
                  deque.add(p);
                  result++;
              }
              
              deque.remove(0);
          } else {
              // 뒤 쪽 덱의 크기가 더 작은 경우, 뒤쪽으로 연산 수행
              for (int j = 0; j < afterSize; j++) {
                  // 뒤쪽에서 뺀 후 앞에 추가
                  int p = deque.remove(deque.size() - 1);
                  deque.add(0, p);
                  result++;
              }
                
              deque.remove(size - 1);
              result++;
          }
      }

      System.out.println(result);
  }
}