import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] people = new int[N][2];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");

                // 서류 심사 성적, 면접 성적의 '순위'가 공백을 두고 한 줄에 주어진다.
                people[i][0] = Integer.parseInt(input[0]);
                people[i][1] = Integer.parseInt(input[1]);
            }

            // 다른 모든 지원자랑 비교할 때 서류와 면접 중 적어도 하나가 다른 지원자보다 떨어지면 안됨
            // 서류/면접 중 1순위를 기준으로 정렬
            Arrays.sort(people, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            // 서류 성적 기준 1위인 사람의 면접 점수
            int distance = people[0][1];

            int result = 1;
            for (int i = 1; i < N; i++) {
                // 해당 사람보다 면접 점수가 떨어지면 둘 다 뒤쳐지는 경우이므로 뽑히지 않음
                if (people[i][1] > distance) {
                    continue;
                }

                // 만약 다음 사람의 면접 점수가 더 높으면 기준점을 갱신해준다.
                // 이미 서류 점수를 기준으로 정렬되어 있어서, 면접 점수가 더 높으면 이후 사람들은 서류와 면접 모두 뒤떨어짐
                distance = people[i][1];
                result++;
            }

            System.out.println(result);
            // 이중 반복문 - 시간 초과
            // int result = 0;
            // for (int i = 0; i < N; i++) {
            //     int[] person = people[i];
            //     boolean isSuccess = true;
                
            //     // 서류 심사 결과와 면접 성적이 '모두' 떨어지면 선발하지 않는다.
            //     for (int j = 0; j < N; j++) {
            //         if (person[0] > people[j][0] && person[1] > people[j][1]) {
            //             isSuccess = false;
            //             break;
            //         }
            //     }

            //     if (isSuccess) {
            //         result++;
            //     }
            // }

            // System.out.println(result);
        }
    }
}