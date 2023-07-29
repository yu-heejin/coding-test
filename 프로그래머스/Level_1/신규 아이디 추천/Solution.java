class Solution {
    private final int MAX_SIZE = 15;
    
    public String solution(String new_id) {
        new_id = stepOne(new_id);
        new_id = stepTwo(new_id);
        new_id = stepThree(new_id);
        new_id = stepFour(new_id);
        new_id = stepFive(new_id);
        new_id = stepSix(new_id);
        new_id = stepSeven(new_id);
        
        return new_id;
    }
    
    private String stepOne(String new_id) {
        return new_id.toLowerCase();
    }
    
    private String stepTwo(String new_id) {
        return new_id.replaceAll("[^a-z0-9-_.]", "");
    }
    
    private String stepThree(String new_id) {
        return new_id.replaceAll("[.]{2,}", ".");
    }
    
    private String stepFour(String new_id) {
        StringBuffer strBuffer = new StringBuffer(new_id);
        
        if (strBuffer.toString().charAt(0) == '.') {
            strBuffer.deleteCharAt(0);
        }
        
        if (strBuffer.toString().length() != 0 && strBuffer.toString().charAt(strBuffer.toString().length() - 1) == '.') {
            strBuffer.deleteCharAt(strBuffer.toString().length() - 1);
        }
        
        return strBuffer.toString();
    }
    
    private String stepFive(String new_id) {
        StringBuffer strBuffer = new StringBuffer(new_id);
        
        if (new_id.length() == 0) {
            strBuffer.append("a");
        }
        
        return strBuffer.toString();
    }
    
    private String stepSix(String new_id) {
        if (new_id.length() > MAX_SIZE) {
            new_id = new_id.substring(0, MAX_SIZE);
            
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        
        return new_id;
    }
    
    private String stepSeven(String new_id) {
        StringBuffer strBuffer = new StringBuffer(new_id);
        
        while(strBuffer.toString().length() < 3) {
            strBuffer.append(new_id.charAt(new_id.length() - 1));
        }
        
        return strBuffer.toString();
    }
}
