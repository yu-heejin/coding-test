import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // val_ext보다 작은 데이터만 추출
        List<int[]> tempData = new ArrayList<>();
        
        for (int i = 0; i < data.length; i++) {
            switch (ext) {
                case "code":
                    if (data[i][0] < val_ext) {
                        tempData.add(data[i]);
                    }
                    break;
                case "date":
                    if (data[i][1] < val_ext) {
                        tempData.add(data[i]);
                    }
                    break;
                case "maximum":
                    if (data[i][2] < val_ext) {
                        tempData.add(data[i]);
                    }
                    break;
                case "remain":
                    if (data[i][3] < val_ext) {
                        tempData.add(data[i]);
                    }
                    break;
            }
        }
        
        // sort_by에 해당하는 값을 기준으로 오름차순
        Collections.sort(tempData, (o1, o2) -> {
            switch (sort_by) {
                case "code":
                    return o1[0] - o2[0];
                case "date":
                    return o1[1] - o2[1];
                case "maximum":
                    return o1[2] - o2[2];
                case "remain":
                    return o1[3] - o2[3];
            }
            
            return o1[0] - o2[0];     // 기본 반환 값이 없으면 오류 발생
        });
        
        int[][] answer = new int[tempData.size()][4];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tempData.get(i);
        }
        
        return answer;
    }
}