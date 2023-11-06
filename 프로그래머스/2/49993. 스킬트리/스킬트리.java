class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            // skill의 문자열을 제외한 모든 문자열
            String skill_tree = skill_trees[i].replaceAll("[^" + skill + "]", "");
            String expected = skill.substring(0, skill_tree.length());
            
            if (skill_tree.equals(expected)) {
                answer++;
            }
        }
        
        return answer;
    }
}