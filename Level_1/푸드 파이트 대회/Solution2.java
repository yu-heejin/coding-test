class Solution {
    public String solution(int[] food) {
        StringBuffer buffer = new StringBuffer();
        int foodIndex = 1;
        
        for (int i = 1; i < food.length; i++) {
            if (food[i] >= 2) {
                for (int j = 1; j <= food[i] / 2; j++) {
                    buffer.append(i);
                }
            }
        }
        
        return buffer.toString() + "0" + buffer.reverse();
    }
}
