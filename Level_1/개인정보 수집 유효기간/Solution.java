import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.Calendar;

class Solution {
    private final int MONTHS = 12;
    private final int DAYS = 28;
    
    private int[] deadline;
    private String[] types;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        deadline = new int[terms.length];
        types = new String[terms.length];
        int[] tempAnswer = new int[privacies.length];
        int tempAnswerIndex = 0;
        
        int todayYear = Integer.parseInt(today.substring(0, 4)) * MONTHS * DAYS;
        int todayMonth = Integer.parseInt(today.substring(5, 7)) * DAYS;
        int todayDay = Integer.parseInt(today.substring(8, 10));
        int todaySum = todayYear + todayMonth + todayDay;
        
        initTypesAndDeadline(terms);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] temps = privacies[i].split(" ");
            int year = Integer.parseInt(temps[0].substring(0, 4)) * MONTHS * DAYS;
            int month = Integer.parseInt(temps[0].substring(5, 7)) * DAYS;
            int day = Integer.parseInt(temps[0].substring(8, 10));
            int index = Arrays.asList(types).indexOf(temps[1]);
            int dateSum = year + month + day + deadline[index];
            
            if (todaySum >= dateSum) {
                tempAnswer[tempAnswerIndex] = i + 1;
                tempAnswerIndex++;
            }
        }
        
        return getAnswer(tempAnswer, tempAnswerIndex);
    }
    
    private void initTypesAndDeadline(String[] terms) {
        for (int i = 0; i < terms.length; i++) {
            String[] temps = terms[i].split(" ");
            deadline[i] = Integer.parseInt(temps[1]) * DAYS;
            types[i] = temps[0];
        }
    }
    
    private int[] getAnswer(int[] tempAnswer, int tempAnswerIndex) {
        int[] answer = new int[tempAnswerIndex];
        
        for (int i = 0; i < tempAnswerIndex; i++) {
            answer[i] = tempAnswer[i];
        }
        
        return answer;
    }
}
