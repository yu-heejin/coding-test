class Solution {
    private final int ACUTE_ANGLE = 1;
    private final int RIGHT_ANGLE = 2;
    private final int OBTUSE_ANGLE = 3;
    private final int STRAIGHT_ANGLE = 4;
    private final int ACUTE_ANGLE_START = 0;
    private final int ACUTE_ANGLE_END = 90;
    private final int RIGHT_ANGLE_NUMBER = 90;
    private final int OBTUSE_ANGLE_START = 90;
    private final int OBTUSE_ANGLE_END = 180;
    
    public int solution(int angle) {
        if (angle > ACUTE_ANGLE_START && angle < ACUTE_ANGLE_END) {
            return ACUTE_ANGLE;
        }
        
        if (angle == RIGHT_ANGLE_NUMBER) {
            return RIGHT_ANGLE;
        }
        
        if (angle > OBTUSE_ANGLE_START && angle < OBTUSE_ANGLE_END) {
            return OBTUSE_ANGLE;
        }
        
        return STRAIGHT_ANGLE;
    }
}
