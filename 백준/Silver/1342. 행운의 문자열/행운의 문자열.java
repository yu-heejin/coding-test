import java.io.*;
import java.util.*;

public class Main {
    
    static long count = 0;
    static int[] alphabetCount;
    static char[] input;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = br.readLine().toCharArray();
        
        alphabetCount = new int[26];
        
        // 조합을 위해 각 알파벳의 개수를 저장한다.
        for (int i = 0; i < input.length; i++) {
            alphabetCount[input[i] - 'a']++;
        }
        
        dfs(0, "");
        
        System.out.println(count);
    }
    
    private static void dfs(int length, String str) {
        if (length == input.length) {
            count++;
            return;
        }
        
        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] == 0) continue;
            
            // 각 알파벳을 하나씩 꺼내면서 문자열을 점검한다.
            char curr = (char) (i + 'a');
            String temp = str;
            
            // 빈 문자열(초기)인 경우 일단 넣는다.
            if (str.equals("")) {
                str += curr;
                alphabetCount[i]--;
                dfs(length + 1, str);
                alphabetCount[i]++;
                str = temp;
            } else if (str.charAt(str.length() - 1) != curr) {
                // 있는 경우 마지막 문자와 다를 경우에만 해당 문자열을 넣는다.
                str += curr;
                alphabetCount[i]--;
                dfs(length + 1, str);
                alphabetCount[i]++;
                str = temp;
            }
        }
    }
}