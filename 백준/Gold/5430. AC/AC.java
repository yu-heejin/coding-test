import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < testCase; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            String input = br.readLine();
            String[] temp = input.substring(1, input.length() - 1).split(",");
            Deque<Integer> arr = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                arr.addLast(Integer.parseInt(temp[i]));
            }
            
            ac(p, arr);
        }
    }
    // 시간초과: 배열의 모든 원소를 뒤집으면 안디며 앞 원소를 무작정 지워서는 안된다.
    private static void ac(String p, Deque<Integer> arr) {
        boolean isReverse = false;
        
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            if (c == 'R') {
                isReverse = isReverse == true ? false : true;
            } else {
                if (arr.size() == 0) {
                    System.out.println("error");
                    return;
                } else {
                    if (isReverse) {
                        arr.removeLast();
                    } else {
                        arr.removeFirst();
                    }
                }
            }
        }
        
        // 결과물 문자열
        StringBuffer bf = new StringBuffer();
        bf.append("[");
        if (isReverse) {
            while (!arr.isEmpty()) {
                bf.append(arr.removeLast());
                if (arr.size() >= 1) {
                    bf.append(",");
                }
            }
        } else {
            while (!arr.isEmpty()) {
                bf.append(arr.removeFirst());
                if (arr.size() >= 1) {
                    bf.append(",");
                }
            }
        }
        bf.append("]");
        System.out.println(bf.toString());
    }
}