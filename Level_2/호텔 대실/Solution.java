// code reference from: https://123okk2.tistory.com/427

import java.util.*;

class Solution {
    private final int CLEAN_TIME = 9;
    private final int START = 0;
    private final int END = 1;
    private final int HOUR = 0;
    private final int MINUTE = 1;
    private List<List<Integer>> times;
    private PriorityQueue<Integer> rooms;
    
    public int solution(String[][] book_time) {
        initTotalMinute(book_time);
        sorting();
        
        return getRooms();
    }
    
    private void initTotalMinute(String[][] book_time) {
        times = new ArrayList<>();
        
        // 시작 시간이 가장 빠른 순서로 정렬하기 위해 시간 변환
        // 시작 시간이 가장 빠르다는 건 변환 결과 값이 가장 작다는 의미
        for (int i = 0; i < book_time.length; i++) {
            List<Integer> time = new ArrayList<>();
            
            String[] startTime = book_time[i][START].split(":");
            String[] endTime = book_time[i][END].split(":");
            
            time.add(getTotalMinute(startTime));
            time.add(getTotalMinute(endTime) + CLEAN_TIME);
            
            times.add(time);
        }
    }
    
    private int getTotalMinute(String[] times) {
        return Integer.parseInt(times[HOUR]) * 60 + Integer.parseInt(times[MINUTE]);
    }
    
    private void sorting() {
        // 시작 시간이 빠른 순서대로 정렬
        // 시작 시간이 같다면, 종료 시간이 빠른 순서로 정렬
        // 시간 복잡도 문제로 Collections.sort 사용
        Collections.sort(times, (a, b) -> {
                if (a.get(START) > b.get(START)) return 1;
                else if (a.get(START) < b.get(START)) return -1;
                else {
                    if (a.get(END) > b.get(END)) return 1;
                    else return -1;
                }
            }
        );
    }
    
    private int getRooms() {
        rooms = new PriorityQueue<>();
        
        // 현재 종료 시간이 이전의 종료 시간보다 작으면(빠르면) 방 추가
        // 우선순위 큐 사용하여 종료 시간이 가장 작은 시간을 꺼낸다.
        for (int i = 0; i < times.size(); i++) {
            if (rooms.size() == 0) {
                rooms.add(times.get(i).get(END));
            } else {
                int exitRoom = rooms.peek();
                
                if (exitRoom < times.get(i).get(START)) {
                    rooms.poll();   // 우선순위 가장 높은 값 제거
                }
                
                rooms.add(times.get(i).get(END));
            }
        }
        
        return rooms.size();
    }
}
