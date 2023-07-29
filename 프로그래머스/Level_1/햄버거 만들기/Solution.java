import java.util.Stack;

class Solution {
    private final int[] ORDER = {1, 2, 3, 1};
    private Stack<Integer> ingredientStacks;
    
    public int solution(int[] ingredient) {
        ingredientStacks = new Stack<>();
        int answer = 0;
        
        for (int i = 0; i < ingredient.length; i++) {
            ingredientStacks.push(ingredient[i]);
            
            if (ingredientStacks.size() >= ORDER.length && checkOrder()) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean checkOrder() {
        int stackSize = ingredientStacks.size();
        
        if (ingredientStacks.get(stackSize - 1) == ORDER[3] 
            && ingredientStacks.get(stackSize - 2) == ORDER[2] 
            && ingredientStacks.get(stackSize - 3) == ORDER[1] 
            && ingredientStacks.get(stackSize - 4) == ORDER[0]) {
            ingredientStacks.pop();
            ingredientStacks.pop();
            ingredientStacks.pop();
            ingredientStacks.pop();
                    
            return true;
        }
        
        return false;
    }
}
