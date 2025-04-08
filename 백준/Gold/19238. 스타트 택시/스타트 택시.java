import java.util.*;
import java.io.*;

class Main {
    private static final int[] MOVE_X = {-1, 1, 0, 0};
    private static final int[] MOVE_Y = {0, 0, -1, 1};
    
    private static int[][] map;
    private static int n, m, fuel;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        fuel = Integer.parseInt(input[2]);

        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        // 백준이 시작점
        int[] position = new int[2];
        input = br.readLine().split(" ");
        position[0] = Integer.parseInt(input[0]);
        position[1] = Integer.parseInt(input[1]);

        // 각 승객의 출발지와 목적지
        int[][] passengers = new int[m][4];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                passengers[i][j] = Integer.parseInt(input[j]);
            }

            // 승객을 -3으로 지정
            map[passengers[i][0]][passengers[i][1]] = -3;
        }

        bfs(position, passengers);

        System.out.println(fuel);
    }

    // 최단 칸 이동을 위한 BFS
    private static void bfs(int[] position, int[][] passengers) {
        boolean[] isArrived = new boolean[m];
        
        while (m > 0) {
            // 최단거리 승객 구하기
            int minIndex = getShortestPassenger(position, passengers, isArrived);
            if (minIndex == -1) {
                fuel = -1;
                break;
            }
            isArrived[minIndex] = true;
            int totalFuel = 0;

            // 출발지까지 이동
            int[] destination = new int[] {passengers[minIndex][0], passengers[minIndex][1]};
            totalFuel = getShortestDistance(position, destination);

            if (totalFuel == -1 || fuel - totalFuel < 0) {
                fuel = -1;
                break;
            }
            
            fuel -= totalFuel;

            // 목적지까지 이동
            destination = new int[] {passengers[minIndex][2], passengers[minIndex][3]};
            totalFuel = getShortestDistance(position, destination);

            if (totalFuel == -1 || fuel - totalFuel < 0) {
                fuel = -1;
                break;
            }
            
            fuel -= totalFuel;
            fuel += totalFuel * 2;
            
            m--;
        }
    }

    private static int getShortestDistance(int[] position, int[] destination) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];

        // 택시의 위치, 총 거리
        q.offer(new int[] {position[0], position[1], 0});
        visited[position[0]][position[1]] = true;

        // 출발지까지 이동
        while (!q.isEmpty()) {
            int[] currPosition = q.poll();

            // System.out.println("curr: " + Arrays.toString(currPosition));

            if (currPosition[0] == destination[0] && currPosition[1] == destination[1]) {
                position[0] = currPosition[0];
                position[1] = currPosition[1];
                return currPosition[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = currPosition[0] + MOVE_X[i];
                int ny = currPosition[1] + MOVE_Y[i];

                if (nx <= 0 || nx > n || ny <= 0 || ny > n) continue;
                if (map[nx][ny] == 1) continue;
                if (visited[nx][ny]) continue;

                q.offer(new int[] {nx, ny, currPosition[2] + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;   // 도착지까지 못갔으면 실패
    }

    private static int getShortestPassenger(int[] position, int[][] passengers, boolean[] isArrived) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];

        // 택시의 위치, 총 거리
        q.offer(new int[] {position[0], position[1], 0});
        visited[position[0]][position[1]] = true;

        // 승객을 담을 리스트
        ArrayList<int[]> passengersDistance = new ArrayList<>();

        // 출발지까지 이동
        while (!q.isEmpty()) {
            int[] currPosition = q.poll();

            if (map[currPosition[0]][currPosition[1]] == -3) {
                // 승객을 찾은 경우, 해당 승객 인덱스를 찾아야한다.
                for (int i = 0; i < passengers.length; i++) {
                    if (currPosition[0] == passengers[i][0] && currPosition[1] == passengers[i][1] && !isArrived[i]) {
                        passengersDistance.add(new int[] {i, currPosition[0], currPosition[1], currPosition[2]});
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = currPosition[0] + MOVE_X[i];
                int ny = currPosition[1] + MOVE_Y[i];

                if (nx <= 0 || nx > n || ny <= 0 || ny > n) continue;
                if (map[nx][ny] == 1) continue;
                if (visited[nx][ny]) continue;

                q.offer(new int[] {nx, ny, currPosition[2] + 1});
                visited[nx][ny] = true;
            }
        }

        // 아무것도 못 넣은 경우는 손님 위치까지 못 한 경우(벽에 가로막힘)
        if (passengersDistance.size() == 0) {
            return -1;
        }

        // 손님 정렬
        Collections.sort(passengersDistance, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[3] == o2[3]) {
                    if (o1[1] == o2[1]) {   // 거리가 같으면 행
                        return o1[2] - o2[2];    // 아니면 열
                    }
                    return o1[1] - o2[1];
                }
                return o1[3] - o2[3];
            }
        });

        // 태운 곳은 0
        map[passengersDistance.get(0)[1]][passengersDistance.get(0)[2]] = 0;
        return passengersDistance.get(0)[0];
    }
}