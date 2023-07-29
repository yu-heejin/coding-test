class Solution {
    private final int WIDTH_INDEX = 0;
    private final int HEIGHT_INDEX = 1;
    
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int width = sizes[i][WIDTH_INDEX];
            int height = sizes[i][HEIGHT_INDEX];
            
            if (height > width) {
                int temp = width;
                width = height;
                height = temp;
            }
            
            if (maxWidth < width) {
                maxWidth = width;
            }
            
            if (maxHeight < height) {
                maxHeight = height;
            }
        }
        
        return maxWidth * maxHeight;
    }
}
