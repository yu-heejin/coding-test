import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      List<Integer> aNums = new ArrayList<>();
      
      String[] input = br.readLine().split(" ");
      
      for (int i = 0; i < n; i++) {
          aNums.add(Integer.parseInt(input[i]));
      }
      
      int m = Integer.parseInt(br.readLine());
      int[] bNums = new int[m];
      
      input = br.readLine().split(" ");
      
      for (int i = 0; i < m; i++) {
          bNums[i] = Integer.parseInt(input[i]);
      }
      
      // 정렬
      Collections.sort(aNums);
      
      // 이진 탐색
      int start = 0;
      int end = n - 1;
      boolean isFined = false;
      
      // 해당 숫자들을 찾은 경우
      for (int i = 0; i < m; i++) {
          while (start <= end) {
              int mid = (start + end) / 2;
              
              if (aNums.get(mid) == bNums[i]) {
                  System.out.println(1);
                  isFined = true;
                  break;
              } else if (aNums.get(mid) > bNums[i]) {
                  end = mid - 1;
              } else {
                  start = mid + 1;
              }
          }
          
          if (!isFined) System.out.println(0);
          
          start = 0;
          end = n - 1;
          isFined = false;
      }
      
      /* 시간 초과 코드
      // 해당 숫자들이 A라는 정수가 존재하는지 확인
      for (int i = 0; i < m; i++) {
          int num = bNums[i];
          
          if (aNums.contains(num)) {
              System.out.println(1);
          } else {
              System.out.println(0);
          }
      }
     */
  }
}