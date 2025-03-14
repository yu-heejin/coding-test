import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 가장 많이 재생된 장르
        HashMap<String, Integer> genreCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreCount.put(
                genres[i], 
                genreCount.getOrDefault(genres[i], 0) + plays[i]
            );
        }
        // 장르 정렬
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(genreCount.entrySet());
        List<String> genresSort = new ArrayList<>();
        entries.sort((o1, o2) -> {
            return genreCount.get(o2.getKey()) - genreCount.get(o1.getKey());
        });
        
        // 정렬된 장르순으로 삽입
        for (Map.Entry<String, Integer> entry : entries) {
            genresSort.add(entry.getKey());
        }
        
        // 장르별 가장 많이 재생된 노래
        List<Integer> pq = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            pq.add(i);
        }
        
        Collections.sort(pq, (o1, o2) -> {
            // 횟수가 같으면 고유번호가 가장 낮은 순서대로
            if (plays[o2] == plays[o1]) {
                return o1 - o2;
            }
            
            // 횟수가 큰 순서로 정렬
            return plays[o2] - plays[o1];
        });
        
        // 장르별 가장 많이 재생된 노래 2개씩 선곡
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[pq.size()];
        for (String genre : genresSort) {
            int count = 0;
            for (Integer i : pq) {
                if (!visited[i] && genres[i].equals(genre)) {
                    visited[i] = true;
                    result.add(i);
                    count++;
                }
                
                if (count >= 2) {
                    break;
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}