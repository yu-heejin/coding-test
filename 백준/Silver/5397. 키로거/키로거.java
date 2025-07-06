import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        for (int t = 0; t < l; t++) {
            String input = br.readLine();
            List<Character> answer = new LinkedList<>();
            ListIterator<Character> currentIndex = answer.listIterator();
                
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                switch (c) {
                    case '<':
                        if (currentIndex.hasPrevious()) {
                            currentIndex.previous();
                        }
                        break;

                    case '>':
                        if (currentIndex.hasNext()) {
                            currentIndex.next();
                        }
                        break;

                    case '-':
                        if (currentIndex.hasPrevious()) {
                            currentIndex.previous();    // remove()는 직전에 next() 또는 previous()로 읽은 요소만 삭제 가능
                            currentIndex.remove();   // O(1)
                        }
                        break;

                    default:
                        // 현재 위치 뒤 위치에 문자 추가
                        currentIndex.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            // for (int i = 0; i < answer.size(); i++) {
                // sb.append(answer.get(i));    // answer.get(i) O(N)
            // }

            for (char c : answer) {
                sb.append(c);
            }

            System.out.println(sb.toString());
        }
    }
}