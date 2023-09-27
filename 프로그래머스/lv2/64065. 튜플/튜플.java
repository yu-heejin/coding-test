import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        // 원소에 한 개 들어있는 값이 맨 처음 값 -> 2개, 3개...
        s = s.replaceAll("[{},]", " ");
        String[] temp = s.split(" ");
        
        List<Integer> tuples = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            if (!temp[i].isEmpty() && !temp[i].equals(" ")) {
                tuples.add(Integer.parseInt(temp[i]));
            }
        }
        
        // 각 등장 숫자 저장
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < tuples.size(); i++) {
            int c = counts.getOrDefault(tuples.get(i), 0);
            counts.put(tuples.get(i), c + 1);
        }
        
        // 값이 큰 순서대로 정렬
        List<Integer> keys = new ArrayList<>(counts.keySet());
        keys.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return counts.get(o2) - counts.get(o1);
            }
        });
        
        return keys.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}