import java.io.*;
import java.util.*;

class City {
    int cost;
    int customer;
    
    public City(int cost, int customer) {
        this.cost = cost;
        this.customer = customer;
    }
}

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int c = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        
        List<City> cities = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            cities.add(new City(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        
        // dp: 해당 비용(인덱스)을 투자했을 때 잠재 고객의 최댓값
        int[] dp = new int[100001];
        
        for (int i = 0; i < cities.size(); i++) {
            City city = cities.get(i);
            for (int j = 1; j <= 100000; j++) {
                // 만약 해당 도시의 비용이 dp 비용보다 작은 경우(처리 가능)
                if (j - city.cost >= 0) {
                    // 기존 값 vs 현재 도시에 투자했을 때 추가 잠재고객
                    // dp[j - city.cost] + city.customer: 현재 비용을 투자하지 않을 때 최대 인원 + 현재 도시의 인원
                    dp[j] = Math.max(dp[j], dp[j - city.cost] + city.customer);
                }
            }
        }
        
        // 답
        int maxPerson = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= 100000; i++) {
            // 최소 인원을 충족하며 가장 큰 인원보다 크고 최소 비용을 만족하는 경우
            if (dp[i] >= c && maxPerson <= dp[i] && minValue >= i) {
                maxPerson = dp[i];
                minValue = i;
            }
        }
        
        System.out.println(minValue);
    }
}