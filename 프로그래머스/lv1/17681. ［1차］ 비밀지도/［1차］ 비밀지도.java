import java.util.*;

class Solution {
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 각 배열 정수 배열 이진수로 변환
        String[] arr1Map = new String[n];
        String[] arr2Map = new String[n];
        
        for (int i = 0; i < n; i++) {
            String arr1Result = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr1[i])));
            String arr2Result = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr2[i])));
            
            arr1Map[i] = arr1Result;
            arr2Map[i] = arr2Result;
        }
        
        String[] answers = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                char a1 = arr1Map[i].charAt(j);
                char a2 = arr2Map[i].charAt(j);
                
                if (a1 == '0' && a2 == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            
            answers[i] = sb.toString();
        }
        
        return answers;
    }
}