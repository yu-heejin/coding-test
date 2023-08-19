import java.io.*;
import java.util.*;

class Main {
	
	private static String[] input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		List<Long> numbers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			numbers.add(Long.parseLong(input[i]));
		}
		
		// 정렬
		Comparator<Long> sorted = new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				long oneCount1 = Long.bitCount(o1);
        long oneCount2 = Long.bitCount(o2);
				
				if (oneCount1 > oneCount2) {
					// 10진수 정수를 2진수로 나타냈을 때 2진수에 포함된 1의 개수를 기준으로 내림차순 정렬한다.
					return -1;
				} else if (oneCount1 == oneCount2) {
					// 1의 개수가 같다면, 원래 10진수를 기준으로 내림차순 정렬한다.
					if (o1 > o2) {
							return -1;
					} else if (o1 < o2) {
							return 1;
					} else {
							return 0;
					}
				} else {
					return 1;
				}
			}
		};
		
		Collections.sort(numbers, sorted);
		System.out.println(numbers.get(k-1));
	}
}
