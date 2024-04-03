import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cash = Integer.parseInt(br.readLine());
        List<Integer> costs = new ArrayList<>();
        
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < input.length; i++) {
            costs.add(Integer.parseInt(input[i]));
        }
        
        // 14일간의 주식 파악
        int sungminCount = 0;
        int sungminCash = cash;
        int junhyunCount = 0;
        int junhyunCash = cash;
        
        for (int i = 0; i < 14; i++) {
            if (junhyunCash >= costs.get(i)) {
                // 준현이는 매수할 수 있는 경우 즉시 매수한다.
                junhyunCount += junhyunCash / costs.get(i);
                junhyunCash -= ((junhyunCash / costs.get(i)) * costs.get(i));
            }
            
            if (i > 3) {
                // 성민이는 3일 연속 하락하는 경우에만 주식을 구매한다.
                if (costs.get(i - 1) < costs.get(i - 2) && costs.get(i - 2) < costs.get(i - 3) && sungminCash >= costs.get(i)) {
                    sungminCount += sungminCash / costs.get(i);
                    sungminCash -= ((sungminCash / costs.get(i)) * costs.get(i));
                }
                
                // 성민이는 3일 연속 상승하는 경우에만 주식을 판매한다.
                if (costs.get(i - 1) > costs.get(i - 2) && costs.get(i - 2) > costs.get(i - 3)) {
                    sungminCash += (sungminCount * costs.get(i));
                    sungminCount = 0;
                }
            }
        }
        
        // 마지막 날 기준 최종 자산
        junhyunCash += (junhyunCount * costs.get(13));
        sungminCash += (sungminCount * costs.get(13));
        
        if (junhyunCash == sungminCash) System.out.println("SAMESAME");
        else if (junhyunCash > sungminCash) System.out.println("BNP");
        else System.out.println("TIMING");
    }
}