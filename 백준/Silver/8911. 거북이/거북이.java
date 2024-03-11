import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        char[] input;
        
        for (int test = 0; test < t; test++) {
            input = br.readLine().toCharArray();
            
            // 방향은 상하좌우(UDLR)
            char currStatus = 'U';
            // (x, y) - x는 가로 y는 세로
            int[] currPosition = {0, 0};
            int minX = 0;
            int maxX = 0;
            int minY = 0;
            int maxY = 0;
            
            for (int i = 0; i < input.length; i++) {
                char command = input[i];
                
                switch (currStatus) {
                    case 'U':
                        if (command == 'L') {
                            currStatus = 'L';
                        } else if (command == 'R') {
                            currStatus = 'R';
                        } else if (command == 'F') {
                            currPosition[1]++;
                        } else {
                            currPosition[1]--;
                        }
                        break;
                    case 'D':
                        if (command == 'L') {
                            currStatus = 'R';
                        } else if (command == 'R') {
                            currStatus = 'L';
                        } else if (command == 'F') {
                            // 세로 길이 증가
                            currPosition[1]--;
                        } else {
                            currPosition[1]++;
                        }
                        break;
                    case 'L':
                        if (command == 'L') {
                            currStatus = 'D';
                        } else if (command == 'R') {
                            currStatus = 'U';
                        } else if (command == 'F') {
                            // 가로 길이 증가
                            currPosition[0]--;
                        } else {
                            currPosition[0]++;
                        }
                        break;
                    case 'R':
                        if (command == 'L') {
                            currStatus = 'U';
                        } else if (command == 'R') {
                            currStatus = 'D';
                        } else if (command == 'F') {
                            // 가로 길이 증가
                            currPosition[0]++;
                        } else {
                            currPosition[0]--;
                        }
                        break;
                }
                
                minX = Math.min(minX, currPosition[0]);
                minY = Math.min(minY, currPosition[1]);
                maxX = Math.max(maxX, currPosition[0]);
                maxY = Math.max(maxY, currPosition[1]);
            }
            
            System.out.println((maxX - minX) * (maxY - minY));
        }
    }
}