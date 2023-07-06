import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
       // List<String> playersToList = Arrays.asList(players);
        Map<String, Integer> ranking = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            // 시간 복잡도 O(n)
            // int index = playersToList.indexOf(callings[i]);
            
            int callee = (int) ranking.get(callings[i]);
            
            // swap
            // playersToList.set(index, player);
            // playersToList.set(index - 1, callee);
            String front = players[callee - 1];
            players[callee - 1] = callings[i];
            players[callee] = front;
            
            ranking.put(front, callee);
            ranking.put(callings[i], callee - 1);
        }
        
        return players;
    }
}