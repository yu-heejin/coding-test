class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] tempTime = pos.split(":");
        int currentTime = Integer.parseInt(tempTime[0]) * 60 + Integer.parseInt(tempTime[1]);
        
        // 오프닝 구간 구하기
        tempTime = op_start.split(":");
        int opStartTime = Integer.parseInt(tempTime[0]) * 60 + Integer.parseInt(tempTime[1]);
        tempTime = op_end.split(":");
        int opEndTime = Integer.parseInt(tempTime[0]) * 60 + Integer.parseInt(tempTime[1]);
        
        // 비디오 총 길이
        tempTime = video_len.split(":");
        int videoTime = Integer.parseInt(tempTime[0]) * 60 + Integer.parseInt(tempTime[1]);
        
        // 명령어 수행
        for (String command : commands) {
            StringBuilder sb = new StringBuilder();
            
            if (currentTime >= opStartTime && currentTime <= opEndTime) {
                // 오프닝 구간에 있으면 건너 뛴다.
                currentTime = opEndTime;
            }
            
            switch (command) {
                case "next":
                    currentTime += 10;
                    if (currentTime > videoTime) {
                        currentTime = videoTime;
                    }
                    break;
                case "prev":
                    currentTime -= 10;
                    if (currentTime < 0) {
                        currentTime = 0;
                    }
                    break;
            }
        }
        
        if (currentTime >= opStartTime && currentTime <= opEndTime) {
            // 오프닝 구간에 있으면 건너 뛴다.
            currentTime = opEndTime;
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(currentTime / 60 < 10 ? "0" + currentTime / 60 : currentTime / 60);
        sb.append(":");
        sb.append(currentTime % 60 < 10 ? "0" + currentTime % 60 : currentTime % 60);
        
        return sb.toString();
    }
}