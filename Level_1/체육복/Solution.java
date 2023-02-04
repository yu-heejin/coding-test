import java.util.Arrays;

class Solution {
    private int[] trainingClothes;
    
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        initTotalTrainingClothes(n, lost, reserve);
        
        for (int i = 0; i < trainingClothes.length; i++) {
            lendTrainingClothes(i);
        }
        
        return getAnswer();
    }
    
    private void initTotalTrainingClothes(int n, int[] lost, int[] reserve) {
        trainingClothes = new int[n];
        
        Arrays.fill(trainingClothes, 1);
        
        for (int i = 0; i < lost.length; i++) {
            trainingClothes[lost[i] - 1]--;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            trainingClothes[reserve[i] - 1]++;
        }
    }
    
    private void lendTrainingClothes(int i) {
        if (i == 0) {
            if (trainingClothes[i] > 1 && trainingClothes[i + 1] == 0) {
                trainingClothes[i]--;
                trainingClothes[i + 1]++;
            }
        } else if (i == trainingClothes.length - 1) {
            if (trainingClothes[i] > 1 && trainingClothes[i - 1] == 0) {
                trainingClothes[i]--;
                trainingClothes[i - 1]++;
            }
        } else {
            if (trainingClothes[i] > 1 && trainingClothes[i - 1] == 0) {
                trainingClothes[i]--;
                trainingClothes[i - 1]++;
            }
            
            if (trainingClothes[i] > 1 && trainingClothes[i + 1] == 0) {
                trainingClothes[i]--;
                trainingClothes[i + 1]++;
            } 
        }
    }
    
    private int getAnswer() {
        int count = 0;
        
        for (int i = 0; i < trainingClothes.length; i++) {
            if (trainingClothes[i] >= 1) {
                count++;
            }
        }
        
        return count;
    }
}
