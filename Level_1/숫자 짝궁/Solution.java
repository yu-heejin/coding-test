import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    private final String NOT_CONTAIN = "-1";
    private ArrayList<String> containNumbers;
    private HashSet<String> tempContainNumbers;
    
    public String solution(String X, String Y) {
        containNumbers = new ArrayList<>();
        tempContainNumbers = new HashSet<>();
        String[] xNumbers = X.split("");
        
        getTempContainNumbers(Y, xNumbers);
        
        if (tempContainNumbers.size() == 0) {
            return NOT_CONTAIN;
        }
        
        getContainNumbers(X, Y);
        
        return getResult();
    }
    
    private void getTempContainNumbers(String Y, String[] xNumbers) {
        for (int i = 0; i < xNumbers.length; i++) {
            if (Y.contains(xNumbers[i])) {
                tempContainNumbers.add(xNumbers[i]);
            }
        }
    }
    
    private void getContainNumbers(String X, String Y) {
        Iterator<String> containIterator = tempContainNumbers.iterator();
        
        while (containIterator.hasNext()) {
            String number = containIterator.next();
            int containSize = getMinContainLength(X, Y, number);
            addContainNumbers(number, containSize);
        }
    }
    
    private int getMinContainLength(String X, String Y, String number) {
        /* code reference from: https://seeminglyjs.tistory.com/426 */
        int xCount = X.length() - X.replace(number, "").length();
        int yCount = Y.length() - Y.replace(number, "").length();
        
        if (xCount < yCount) {
            return xCount;
        }
        
        return yCount;
    }
    
    private void addContainNumbers(String number, int containSize) {
        for (int i = 0; i < containSize; i++) {
            containNumbers.add(number);
        }
    }
    
    private String getResult() {
        Collections.sort(containNumbers, Comparator.reverseOrder());
        
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < containNumbers.size(); i++) {
            buffer.append(containNumbers.get(i));
        }
        
        if (buffer.toString().replace("0", "").length() == 0) {
            return "0";
        }
        
        return buffer.toString();
    }
}
