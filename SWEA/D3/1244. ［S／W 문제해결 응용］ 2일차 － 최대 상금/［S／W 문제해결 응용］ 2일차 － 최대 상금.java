
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int answer;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            answer = -1;
			int number = sc.nextInt();
            int count = sc.nextInt();
            
            char[] numbers = Integer.toString(number).toCharArray();
            
            if (count > numbers.length) {
                count = numbers.length;
            }
            dfs(count, 0, numbers);
            System.out.println("#" + test_case + " " + answer);
		}
	}
    
    private static void dfs(int depth, int start, char[] numbers) {
        if (depth == 0) {
            int number = Integer.parseInt(new String(numbers));
            
            if (answer < number) {
                answer = number;
            }
            
            return;
        }
        
        for (int i = start; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                char temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                
                dfs(depth - 1, i, numbers);
                
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
    }
}