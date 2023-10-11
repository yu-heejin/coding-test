import java.util.*;

class Record {
    
    String carNum;
    String inTime;
    String outTime;
    int totalTime;
    int cost;
    
    public Record(String carNum, String inTime) {
        this.carNum = carNum;
        this.inTime = inTime;
        totalTime = 0;
        cost = 0;
    }
    
    public String toString() {
        return carNum + ": " + inTime + " ~ " + outTime;
    }
}

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        List<Record> results = new ArrayList<>();
        
        for (String record : records) {
            String[] token = record.split(" ");
            if (token[2].equals("IN")) {
                Record r = new Record(token[1], token[0]);
                results.add(r);
            } else {
                for (Record r : results) {
                    if (r.carNum.equals(token[1]) && r.outTime == null) {
                        r.outTime = token[0];
                        break;
                    }
                }
            }
        }
        
        Map<String, Integer> times = new TreeMap<>();
        for (Record record : results) {
            if (record.outTime == null) {
                record.outTime = "23:59";
            }
            
            String[] inTimeToken = record.inTime.split(":");
            int inHour = Integer.parseInt(inTimeToken[0]) * 60;
            int inMinute = Integer.parseInt(inTimeToken[1]);
            
            String[] outTimeToken = record.outTime.split(":");
            int outHour = Integer.parseInt(outTimeToken[0]) * 60;
            int outMinute = Integer.parseInt(outTimeToken[1]);
            
            int total = (outHour + outMinute) - (inHour + inMinute);
            
            int sumTime = times.getOrDefault(record.carNum, 0) + total;
            times.put(record.carNum, sumTime);
        }
        
        int[] answer = new int[times.size()];
        int i = 0;
        for (String key : times.keySet()) {
            int time = times.get(key);
            int fee = fees[1];
            
            if (time > fees[0]) {
                int addTime = (int)Math.ceil((time - fees[0]) / (double)fees[2]);
                fee += fees[3] * addTime;
            }
            
            answer[i] = fee;
            i++;
        }
        
        return answer;
    }
}