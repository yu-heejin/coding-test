import java.util.*;
import java.io.*;

class City {
    int start;
    int end;
    int km;
    int cost;

    public City(int start, int end, int km) {
        this.start = start;
        this.end = end;
        this.km = km;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 개수
        int N = Integer.parseInt(br.readLine());

        // 인접한 두 도시를 연결하는 도로의 길이가 제일 왼쪽 도로부터 자연수로 주어진다.
        String[] input = br.readLine().split(" ");
        List<City> cities = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (i == N - 1) cities.add(new City(i, 0, 0));
            else cities.add(new City(i, i + 1, Integer.parseInt(input[i])));
        }

        // 주유소의 리터당 가격
        input = br.readLine().split(" ");
        int minCostCity = 0;   // 주유소 가격이 가장 저렴한 도시
        int minCost = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            City city = cities.get(i);
            city.setCost(Integer.parseInt(input[i]));

            if (i < N-1 && minCost >= city.cost) {
                minCost = city.cost;
                minCostCity = i;
            }

            sum += city.km;
        }

        int total = 0;
        for (int i = 0; i < N - 1; i++) {
            City city = cities.get(i);
            // 현재 방문한 도시가 가장 작은 기름값을 가진 경우
            if (i == minCostCity) {
                // 여기서 남은 거리만큼 다 충전해서 가야함
                total += (sum * city.cost);
                break;
            } else {
                // 아니라면 다음 도시랑 비교해서 다음 도시보다 싸면 다음 도시것까지 다 충전
                City next = cities.get(i + 1);
                // 다음 도시보다 현재 도시가 더 저렴
                if (city.cost < next.cost) {
                    total += ((city.km + next.km) * city.cost);
                    sum -= (city.km + next.km);
                } else {
                    // 아닌 경우는 여기서 거리만큼만 충전
                    total += (city.km * city.cost);
                    sum -= city.km;
                }
            }
        }

        System.out.println(total);
    }
}