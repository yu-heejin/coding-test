import java.util.*;

class Music {
    int id;
    int playCount;
    String genre;
    int genreCount;
    
    public Music(int id, int playCount, String genre, int genreCount) {
        this.id = id;
        this.playCount = playCount;
        this.genre = genre;
        this.genreCount = genreCount;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 속한 노래가 많이 재생된 장르순 정렬
        Map<String, Integer> genresCount = new TreeMap<>();
        Map<String, Integer> musicCount = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genresCount.put(
                genres[i], 
                genresCount.getOrDefault(genres[i], 0) + plays[i]
            );
            
            musicCount.put(genres[i], 2);
        }
        
        // 객체별 정렬
        List<Music> music = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            music.add(new Music(i, plays[i], genres[i], genresCount.get(genres[i])));
        }
        
        // 장르 재생 > 장르 내 재생 > 고유번호 낮은 순 정렬
        Collections.sort(music, (o1, o2) -> {
            if (o1.genreCount == o2.genreCount) {
                if (o1.playCount == o2.playCount) {
                    return o1.id - o2.id;
                }
                
                return o2.playCount - o1.playCount;
            }
            
            return o2.genreCount - o1.genreCount;
        });
        
        List<Integer> answer = new ArrayList<>();
        
        for (Music m : music) {
            if (musicCount.get(m.genre) > 0) {
                answer.add(m.id);
                musicCount.put(m.genre, musicCount.get(m.genre) - 1);
            }
        }
        
        int[] result = new int[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}