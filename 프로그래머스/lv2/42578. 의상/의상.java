import java.util.*;

/**
    예를들어 머리:3, 얼굴:2, 옷:1 이라면 총 가능한 개수는
    (3+1) * (2+1)*(1+1) -1 = 13
    +1씩을 더한 것은 착용하지 않은 경우가 추가 되기 때문이고 마지막으로 -1을 한것은 모든 부위를 입지 않은 경우는 없기 때문입니다.
    
    즉, 모든 종류로 조합하는 경우 각 카테고리에 있는 가짓수를 서로 곱하고,
    +1을 해서 해당 카테고리 옷을 선택하지 않은 경우를 추가하고
    -1을 해서 모든 옷을 입지 않는 경우를 빼준다.
*/
class Solution {
    
    public int solution(String[][] clothes) {
        Map<String, List<String>> clothesPerCategory = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            clothesPerCategory.put(clothes[i][1], new ArrayList<String>());
        }
        
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String category = cloth[1];
            
            List<String> temp = clothesPerCategory.get(category);
            temp.add(name);
        }
        
        int result = 1;
        
        for (String category : clothesPerCategory.keySet()) {
            result *= (clothesPerCategory.get(category).size() + 1);
        }
        
        return result - 1;
    }
}