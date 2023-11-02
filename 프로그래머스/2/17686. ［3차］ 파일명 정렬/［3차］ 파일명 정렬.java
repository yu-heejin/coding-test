import java.util.*;

class Solution {
    
    public String[] solution(String[] files) {
        String[][] splits = new String[files.length][3];
        
        for (int i = 0; i < files.length; i++) {
            // HEAD, NUMBER 분리
            int numberFirst = 0;
            int numberLast = 0;
            for (int j = 0; j < files[i].length(); j++) {
                if (Character.isDigit(files[i].charAt(j))) {
                    numberFirst = j;
                    for (numberLast = j; numberLast < files[i].length() && Character.isDigit(files[i].charAt(numberLast)); numberLast++);
                    break;
                }
            }
            
            String header = files[i].substring(0, numberFirst);
            String number = files[i].substring(numberFirst, numberLast);
            String tail = files[i].substring(numberLast);
            
            splits[i][0] = header;
            splits[i][1] = number;
            splits[i][2] = tail;
        }
        
        Arrays.sort(splits, (o1, o2) -> {
            // HEAD를 기준으로 사전순으로 정렬한다.
            if (o1[0].toLowerCase().compareTo(o2[0].toLowerCase()) == 0) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
            
            return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
        });
        
        String[] answers = new String[files.length];
        
        int index = 0;
        for (String[] split : splits) {
            answers[index] = split[0] + split[1] + split[2];
            index++;
        }
        
        return answers;
    }
}