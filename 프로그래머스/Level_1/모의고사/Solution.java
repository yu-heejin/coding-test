import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/* code reference from: 
 - https://velog.io/@ppmyor/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Programmers-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-javascript
 - https://velog.io/@hi_potato/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-JAVA 
*/
class Solution {
    private final int[] CHECK_ONE = {1, 2, 3, 4, 5};
    private final int[] CHECK_TWO = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] CHECK_THREE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] answerCounts = getAnswerCount(answers);
        Set<Integer> tempAnswer = getMaxPerson(answerCounts);

        return getAnswer(tempAnswer);
    }
    
    private int[] getAnswerCount(int[] answers) {
        int checkOneLength = CHECK_ONE.length;
        int checkTwoLength = CHECK_TWO.length;
        int checkThreeLength = CHECK_THREE.length;
        int answerOneCount = 0;
        int answerTwoCount = 0;
        int answerThreeCount = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (CHECK_ONE[i % checkOneLength] == answers[i]) {
                answerOneCount++;
            }
            
            if (CHECK_TWO[i % checkTwoLength] == answers[i]) {
                answerTwoCount++;
            }
            
            if (CHECK_THREE[i % checkThreeLength] == answers[i]) {
                answerThreeCount++;
            }
        }
        
        return new int[] {answerOneCount, answerTwoCount, answerThreeCount};
    }
    
    private Set<Integer> getMaxPerson(int[] answerCounts) {
        Set<Integer> tempAnswer = new TreeSet<>();
        int max = Math.max(answerCounts[0], Math.max(answerCounts[1], answerCounts[2]));
        int maxPerson = 0;
        
        for (int i = 0; i < answerCounts.length; i++) {
            if (max <= answerCounts[i]) {
                max = answerCounts[i];
                maxPerson = i;
                tempAnswer.add(++maxPerson);
            }
        }
        
        return tempAnswer;
    }
    
    private int[] getAnswer(Set<Integer> tempAnswer) {
        int[] answer = new int[tempAnswer.size()];
        int answerIndex = 0;
        Iterator<Integer> iterator = tempAnswer.iterator();
        
        while (iterator.hasNext()) {
            answer[answerIndex] = iterator.next();
            answerIndex++;
        }
        
        return answer;
    }
}
