import java.util.*;

class Music implements Comparable<Music>{
    int index;
    String genre;
    int plays;
    
    public Music(int index, int plays, String genre) {
        this.index = index;
        this.plays = plays;
        this.genre = genre;
    }
    
    @Override
    public int compareTo(Music other) {
        if (other.plays == this.plays) {
            return this.index - other.index;
        }
        
        return other.plays - this.plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 재생횟수
        Map<String, Integer> counts = new HashMap<>();
        // 장르별 음악
        Map<String, List<Music>> musics = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            counts.put(genres[i], counts.getOrDefault(genres[i], 0) + plays[i]);
            
            Music m = new Music(i, plays[i], genres[i]);
            List<Music> temp = musics.getOrDefault(genres[i], new ArrayList<Music>());
            temp.add(m);
            musics.put(genres[i], temp);
        }
        
        // 장르순 정렬
        List<String> genreKeys = new ArrayList<>(musics.keySet());
        Collections.sort(genreKeys, (o1, o2) -> {
           return counts.get(o2) - counts.get(o1); 
        });
        
        List<Integer> temp = new ArrayList<>();
        
        for (String music : genreKeys) {
            List<Music> list = musics.get(music);
            Collections.sort(list);
            
            for (int i = 0; i < 2; i++) {
                if (list.size() - 1 < i) break;
                
                temp.add(list.get(i).index);
            }
        }
        
        return temp.stream().mapToInt(i -> i).toArray();
    }
}