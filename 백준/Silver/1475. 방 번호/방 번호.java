import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = 1;
        }
        int answer = 1;
        
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                if (num == j) {
                    if (numbers[j] == 0) {
                        if (j == 9 && numbers[6] > 0) {
                            numbers[6]--;
                            break;
                        } else if (j == 6 && numbers[9] > 0) {
                            numbers[9]--;
                            break;
                        } else {
                            answer++;
                            for (int k = 0; k < 10; k++) {
                                numbers[k]++;
                            }
                        }
                    }

                    if (numbers[j] > 0) {
                        numbers[j]--;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}