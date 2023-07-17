import java.util.*;
import java.io.*;

class House implements Comparable<House> {
    
    private int me;
    private int connectedHouse;
    private int cost;
    
    public House(int me, int connectedHouse, int cost) {
        this.me = me;
        this.connectedHouse = connectedHouse;
        this.cost = cost;
    }
    
    public int getCost() {
        return cost;
    }
    
    public int getMe() {
        return me;
    }
    
    public int getConnectedHouse() {
        return connectedHouse;
    }
    
    @Override
    public int compareTo(House other) {
        return this.cost - other.cost;
    }
}

public class Main {
    
    private static String[] input;
    private static int[] parent;
    private static List<House> houses;
    
    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = findParent(parent[x]);
    }
    
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        input = reader.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        parent = new int[n + 1];
        houses = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            houses.add(new House(a, b, c));
        }
        
        Collections.sort(houses);   // 오름차순 정렬
        
        int result = 0;
        int max = 0;
        
        for (int i = 0; i < houses.size(); i++) {
            int cost = houses.get(i).getCost();
            int me = houses.get(i).getMe();
            int connectedHouse = houses.get(i).getConnectedHouse();
            
            if (findParent(me) != findParent(connectedHouse)) {
                unionParent(me, connectedHouse);
                result += cost;
                max = cost;
            }
        }
        
        System.out.println(result - max);
    }
}