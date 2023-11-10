import java.util.*;
import java.io.*;

class Planet {
    int x;
    int y;
    int z;
    int index;
    
    public Planet(int x, int y, int z, int index) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
    }
}

class Edge implements Comparable<Edge> {
    int o1;
    int o2;
    int value;
    
    public Edge(int o1, int o2, int value) {
        // n번째 행성
        this.o1 = o1;
        // n + 1번째 행성
        this.o2 = o2;
        // 두 행성 사이의 간선의 비용
        this.value = value;
    }
    
    @Override
    public int compareTo(Edge e) {
        return this.value - e.value;
    }
}

public class Main {
    
    static int[] parents;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<Planet> planets = new ArrayList<>();
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            
            planets.add(new Planet(x, y, z, i));
            parents[i] = i;
        }
        
        PriorityQueue<Edge> q = new PriorityQueue<>();
        
        // x순 정렬
        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x - o2.x;
            }
        });
        for (int i = 0; i < n - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i + 1);
            int value = Math.abs(p1.x - p2.x);
            q.add(new Edge(p1.index, p2.index, value));
        }
        
        // y순 정렬
        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y - o2.y;
            }
        });
        for (int i = 0; i < n - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i + 1);
            int value = Math.abs(p1.y - p2.y);
            q.add(new Edge(p1.index, p2.index, value));
        }
        
        // z순 정렬
        Collections.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z - o2.z;
            }
        });
        for (int i = 0; i < n - 1; i++) {
            Planet p1 = planets.get(i);
            Planet p2 = planets.get(i + 1);
            int value = Math.abs(p1.z - p2.z);
            q.add(new Edge(p1.index, p2.index, value));
        }
        
        int answer = 0;
        while (!q.isEmpty()) {
            Edge e = q.poll();
            
            if (find(e.o1) != find(e.o2)) {
                answer += e.value;
                union(e.o1, e.o2);
            }
        }
        
        System.out.println(answer);
    }
    
    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) {
            return false;
        }
        
        if (x < y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
        
        return true;
    }
    
    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        
        return find(parents[x]);
    }
}