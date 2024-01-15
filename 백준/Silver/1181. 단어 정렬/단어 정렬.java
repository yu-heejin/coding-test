import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    // 문자열 길이가 더 작은 쪽이 앞으로 온다.
                    return -1;
                } else if (o1.length() == o2.length()) {
                    // 길이가 같으면 사전순 비교
                    // 이 때 두 문자열이 같은 경우 (0인 경우) 중복을 제거한다.
                    return o1.compareTo(o2);
                } else {
                    // 그게 아니면 뒤로 이동
                    return 1;
                }
            }
        };
        
        int n = Integer.parseInt(br.readLine());
        Set<String> input = new TreeSet<>(comp);
        
        for (int i = 0; i < n; i++) {
            input.add(br.readLine());
        }
        
        for (String i : input) {
            System.out.println(i);
        }
    }
}