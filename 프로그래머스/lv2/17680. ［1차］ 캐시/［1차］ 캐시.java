import java.util.*;

// LRU 알고리즘, 맨 뒤에 있는 값이 가장 최근에 참조되었다고 가정한다.

class Solution {
    
    private final int CACHE_HIT = 1;
    private final int CACHE_MISS = 5;
    
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * CACHE_MISS;
        }
        
        List<String> cache = new ArrayList<>();
        int time = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            int index = cache.indexOf(city);
            
            if (cache.size() == 0) {
                cache.add(city);
                time += CACHE_MISS;
            } else if (index != -1) {
                // 해당 캐시 안에 값이 존재하는 경우
                if (cacheSize > 1) {
                    for (int i = index; i < cache.size() - 1; i++) {
                        cache.set(i, cache.get(i + 1));
                    }
                    
                    cache.set(cache.size() - 1, city);
                }
                
                time += CACHE_HIT;
            } else {
                // 해당 캐시 안에 값이 존재하지 않는 경우
                if (cacheSize == 1) {
                    cache.set(0, city);
                } else if (cache.size() < cacheSize) {
                    cache.add(cache.size(), city);
                } else {
                    for (int i = 0; i < cache.size() - 1; i++) {
                        cache.set(i, cache.get(i + 1));
                    }
                    
                    cache.set(cache.size() - 1, city);
                }
                
                time += CACHE_MISS;
            }
        }
        
        return time;
    }
}