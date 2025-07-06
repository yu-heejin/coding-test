import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int m = Integer.parseInt(br.readLine());

        // 초기 문자열 LinkedList에 추가
        List<Character> userInput = new LinkedList<>();
        ListIterator<Character> currentIndex = userInput.listIterator();

        for (int i = 0; i < input.length(); i++) {
            currentIndex.add(input.charAt(i));
        }

        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            
            switch (command[0]) {
                case "L":
                    if (currentIndex.hasPrevious()) {
                        currentIndex.previous();
                    }
                    break;

                case "D":
                    if (currentIndex.hasNext()) {
                        currentIndex.next();
                    }
                    break;

                case "B":
                    if (currentIndex.hasPrevious()) {
                        // 왼쪽에 있는 문자를 삭제한다.
                        currentIndex.previous();
                        currentIndex.remove();
                    }
                    break;

                case "P":
                    // currentIndex.previous();
                    // iterator는 Node의 뒤에 위치
                    currentIndex.add(command[1].charAt(0));
                    break; 
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : userInput) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}