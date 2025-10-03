class Solution {
    int max = -1;
    int[] answer;
    
    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        dfs(new int[info.length], n, info);
        
        if (max == -1) {
            return new int[] { -1 };
        }
        return answer;
    }
    
    private void dfs(int[] scores, int n, int[] info) {
        // 점수 얻기: 어피치가 k점을 맞춘 횟수보다 1만큼 더 쏘거나 아예 쏘지 않는 경우
        for (int i = 0; i < info.length; i++) {
            if (scores[i] == 0 && info[i] < n) {
                scores[i] = info[i] + 1;
                n -= (info[i] + 1);
                dfs(scores, n, info);
                scores[i] = 0;
                n += (info[i] + 1);
            }
        }
        
        // 화살이 남은 경우
        if (n >= 0) {
            scores[10] = n;
        }
        
        int apeachTotal = 0;
        int lionTotal = 0;

        // 가장 큰 점수차 계산
        for (int i = 0; i < info.length; i++) {
            int apeach = info[i];
            int lion = scores[i];

            if (apeach == 0 && lion == 0) continue;

            if (apeach >= lion) {
                apeachTotal += 10 - i;
            } else {
                lionTotal += 10 - i;
            }
        }

        if (lionTotal - apeachTotal > 0 && lionTotal - apeachTotal > max) {
            answer = scores.clone();
            max = lionTotal - apeachTotal;
        } else if (lionTotal - apeachTotal > 0 && lionTotal - apeachTotal == max) {
            for (int i = 10; i >= 0; i--) {
                if (answer[i] < scores[i]) {
                    answer = scores.clone();
                    break;
                }
            }
            max = lionTotal - apeachTotal;
        }
    }
}