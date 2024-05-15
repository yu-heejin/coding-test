import java.io.*;
import java.util.*;

class Egg {
    int durability;
    int weight;
    
    public Egg(int durability, int weight) {
        this.durability = durability;
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return durability + ", " + weight;
    }
}

public class Main {
    
    private static List<Egg> eggs = new ArrayList<>();
    private static int n;
    private static int max = Integer.MIN_VALUE;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            eggs.add(new Egg(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        
        dfs(0);
        
        System.out.println(max);
    }
    
    private static void dfs(int index) {
        // 손에 든 계란이 마지막 계란인 경우
        if (index == n) {
            int count = 0;
            
            // 얼마나 깨졌는지 확인
            for (Egg egg : eggs) {
                if (egg.durability <= 0) {
                    count++;
                }
            }
            
            max = Math.max(max, count);
            return;
        }
        
        // 이미 손으로 들고 있는 계란
        Egg curr = eggs.get(index);
        
        // 이미 깨진 계란인 경우 다음 계란으로 넘어간다.
        if (curr.durability <= 0) {
            dfs(index + 1);
        } else {
            // 현재 든 계란을 기준으로 계란을 하나씩 깬다.
            boolean isAllBroken = true;
            
            for (int i = 0; i < n; i++) {
                // 현재 계란과 같은 계란인 경우 continue
                if (i == index) continue;
                
                Egg egg = eggs.get(i);
                
                // 이미 깨진 계란인 경우 continue
                if (egg.durability <= 0) continue;
                
                isAllBroken = false;
                
                // 계란을 깬다
                egg.durability -= curr.weight;
                curr.durability -= egg.weight;
                dfs(index + 1);
                egg.durability += curr.weight;
                curr.durability += egg.weight;
            }
            
            // 이미 다 깨진 계란인 경우
            int count = 0;
            
            // 얼마나 깨졌는지 확인
            for (Egg egg : eggs) {
                if (egg.durability <= 0) {
                    count++;
                }
            }
            
            max = Math.max(max, count);
        }
    }
}