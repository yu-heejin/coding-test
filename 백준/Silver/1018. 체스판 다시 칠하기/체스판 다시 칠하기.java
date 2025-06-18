import java.util.*;
import java.io.*;

public class Main {
    private static final String[] white = {
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
    };
    private static final String[] black = {
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
    };
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);   // 행 개수(세로)
        int M = Integer.parseInt(input[1]);   // 열 개수 (가로)

        String[] board = new String[N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        int answer = 50 * 50;
        
        // 가로/세로 시작점으로 가질 수 있는 최대값
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // 시작 지점의 색깔
                int whiteChange = 0;
                int blackChange = 0;

                // 시작 지점부터 한 줄씩 내려가며 확인
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        char current = board[i + k].charAt(j + l);

                        // 시작 지점이 검정, 화이트인 경우 두가지 모두를 비교한다.
                        // 만약, 시작 지점이 화이트인데 검정으로 바꾼다면, 검정색 보드판 기준으로 비교해야 한다.
                        // 두 경우를 비교해서 더 적게 바꾸는 쪽을 선택한다.
                        if (current != white[k].charAt(l)) whiteChange++;
                        if (current != black[k].charAt(l)) blackChange++;
                    }
                }

                answer = Math.min(answer, Math.min(whiteChange, blackChange));
            }
        }

        System.out.println(answer);
    }
}