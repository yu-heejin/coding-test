import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 처리된 가장 큰 매트
        int maxMats = -1;
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length; j++) {
                // 만약 시작 지점이 -1이라면, 해당 위치부터 돗자리 크기만큼 탐색
                if (park[i][j].equals("-1")) {
                    for (int k = 0; k < mats.length; k++) {
                        // 가로/세로의 길이가 돗자리 길이보다 작으면 탐색하지 않는다.
                        if (i + mats[k] - 1 >= park.length) {
                            continue;
                        }
                        
                        if (j + mats[k] - 1 >= park[i].length) {
                            continue;
                        }
                        
                        // 해당 위치만큼 빈자리가 있나 탐색
                        boolean isSuccess = true;
                        for (int l = i; l < i + mats[k]; l++) {
                            for (int m = j; m < j + mats[k]; m++) {
                                if (!park[l][m].equals("-1")) {
                                    isSuccess = false;
                                    break;
                                }
                            }
                        }
                        // 성공 시 해당 돗자리 처리 완료
                        if (isSuccess) {
                            maxMats = Math.max(maxMats, mats[k]);
                        }
                    }
                }
            }
        }
        
        return maxMats;
    }
}