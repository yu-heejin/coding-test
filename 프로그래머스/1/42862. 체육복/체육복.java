import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 문제에서 입력이 순서대로 들어온다는 보장이 없으므로, 정렬한다.
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer> lostStudents = new ArrayList<>();
        List<Integer> reserveStudents = new ArrayList<>();
        
        // 도둑맞은 학생들 추가
        for (int i = 0; i < lost.length; i++) {
            lostStudents.add(lost[i]);
        }
        
        // 여분의 체육복을 가져온 학생들 추가
        for (int i = 0; i < reserve.length; i++) {
            reserveStudents.add(reserve[i]);
        }
        
        // 여분의 학생이 도둑맞은 경우, 그 경우를 제외한다.
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    // 일반 int 값을 넣을 경우, 인덱스 값으로 인식해 오류가 발생한다.
                    lostStudents.remove(Integer.valueOf(lost[i]));
                    reserveStudents.remove(Integer.valueOf(reserve[j]));
                }
            }
        }
        
        // 도둑맞은 학생들 구제 - 앞/뒷번호 중 하나를 골라 기준을 잡고 체육복을 빌려준다.
        // 뒷번호를 먼저 빌려주는 경우 1번이 여분의 체육복을 갖고 있을 때 최대 체육복 학생이 나올 수 없음
        for (int i = 0; i < reserveStudents.size(); i++) {
            if (lostStudents.contains(reserveStudents.get(i) - 1)) {
                lostStudents.remove(Integer.valueOf(reserveStudents.get(i) - 1));
            } else if (lostStudents.contains(reserveStudents.get(i) + 1)) {
                lostStudents.remove(Integer.valueOf(reserveStudents.get(i) + 1));
            }
        }
        
        return n - lostStudents.size();
    }
}