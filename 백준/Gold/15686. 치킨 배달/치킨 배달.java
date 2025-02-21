import java.util.*;
import java.io.*;

class Main {
    private static int minTotalSum = Integer.MAX_VALUE;
    private static int N, M;
    private static int[][] city;
    private static List<int[]> chickens, houses;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        city = new int[N][N];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(input[j]);
                
                if (city[i][j] == 2) {
                    chickens.add(new int[] {i, j});
                } else if (city[i][j] == 1) {
                    houses.add(new int[] {i, j});
                }
            }
        }

        if (chickens.size() == M) {
            System.out.println(getChickenDistance(chickens));
        } else {
            collection(chickens.size(), M, new int[M]);
            System.out.println(minTotalSum);
        }
    }

    /* 조합 - 어짜피 M개 남겨놔도 집 개수는 동일하니 이왕 이리된거 가장 짧은 거리를 가진 치킨집만 남길것, 왜냐하면 자기들이 연구했을 때 M개가 큰 수익을 낼 수 있다고 미리 문제에 있음 */
    private static void collection(int n, int r, int[] bucket) {
        if (r == 0) {
            int totalSum = 0;

            List<int[]> newChickens = new ArrayList<>();

            for (int i = 0; i < bucket.length; i++) {
                newChickens.add(chickens.get(bucket[i]));
            }

            minTotalSum = Math.min(minTotalSum, getChickenDistance(newChickens));

            return;
        }

        int lastIndex = bucket.length - r - 1;
        int smallest = 0;

        // 하나라도 뽑아서 r 값이 줄어드는 경우
        if (bucket.length > r) {
            smallest = bucket[lastIndex] + 1;
        }

        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            collection(n, r - 1, bucket);
        }
    }

    /* 각 집을 기준으로 치킨 거리 구하는 함수 - 치킨 거리는 치킨집 기준이 아니라 각 집 기준으로 가장 가까운 치킨집과의 거리를 찾는 것임 */
    private static int getChickenDistance(List<int[]> chickens) {
        int result = 0;
        
        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;   // 각 집과 가장 가까운 치킨집 거리
            for (int[] chicken : chickens) {
                minDistance = Math.min(minDistance, Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]));
            }
            result += minDistance;
        }

        return result;
    }
}