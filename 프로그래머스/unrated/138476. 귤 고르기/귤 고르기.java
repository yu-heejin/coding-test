import java.util.*;

class Solution {
    private Map<Integer, Integer> typeCount;
    
    public int solution(int k, int[] tangerine) {
        typeCount = new HashMap<>();
        
        for (int t : tangerine) {
            typeCount.put(t, typeCount.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> types = new ArrayList<>(typeCount.keySet());
        
        Collections.sort(types, 
                         (o1, o2) -> (typeCount.get(o2).compareTo(typeCount.get(o1))));
        int result = 0;
        
        for (int i = 0; i < types.size(); i++) {
            // k는 귤의 개수이다.
            k -= typeCount.get(types.get(i));
            result++;
            
            // k == 0일때 답이 안되는 이유는 귤의 개수가 k보다 많을 수 있기 때문이다 (입출력 예 3)
            if (k < 1) {
                break;
            }
        }
        
        return result;
    }
}