import java.util.*;

class Music implements Comparable<Music> {
    int index;
    int plays;
    String genre;
    
    public Music(int index, int plays, String genre) {
        this.index = index;
        this.plays = plays;
        this.genre = genre;
    }
    
    @Override
    public int compareTo(Music o) {
        if (o.plays == this.plays) {
            return this.index - o.index;
        }
        
        return o.plays - this.plays;
    }
    
    @Override
    public String toString() {
        return "[" + index + "] " + genre + ", " + plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Music>> playsPerGenres = new HashMap<>();
        
        // 장르, 노래, 고유 번호 저장
        for (int i = 0; i < genres.length; i++) {
            Music m = new Music(i, plays[i], genres[i]);
            
            List<Music> musics = playsPerGenres.getOrDefault(genres[i], new ArrayList<Music>());
            musics.add(m);
            playsPerGenres.put(genres[i], musics);
        }
        
        // 해당 장르 내에서 가장 많이 재생된 노래 확인
        // 정렬
        for (String key : playsPerGenres.keySet()) {
            Collections.sort(playsPerGenres.get(key));
        }
        
        // 크기순으로 key 정렬 - 정렬을 위한 set to list
        List<String> keys = new ArrayList<>(playsPerGenres.keySet());
        
        Collections.sort(keys, (o1, o2) -> {
            List<Music> musics1 = playsPerGenres.get(o1);
            List<Music> musics2 = playsPerGenres.get(o2);
            int sum1 = 0;
            int sum2 = 0;
            
            for (Music m : musics1) {
                sum1 += m.plays;
            }
            
            for (Music m : musics2) {
                sum2 += m.plays;
            }
            
            return sum2 - sum1;
        });
        
        List<Integer> tempAnswer = new ArrayList<>();
        
        for (String key : keys) {
            int count = 0;
            for (Music m : playsPerGenres.get(key)) {
                if (count >= 2) break;
                
                tempAnswer.add(m.index);
                count++;
            }
        }
        
        int[] answer = new int[tempAnswer.size()];
        
        for (int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }
        
        return answer;
    }
}