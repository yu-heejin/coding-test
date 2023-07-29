class Solution {
    public String solution(int[] food) {
        String answer = "";
        int foodIndex = 1;
        
        for (int i = 1; i < food.length; i++) {
            if (food[i] >= 2) {
                for (int j = 1; j <= food[i] / 2; j++) {
                    answer += i;
                }
            }
        }
        
        StringBuilder builder = new StringBuilder(answer);
        return answer + "0" + builder.reverse();
    }
}
