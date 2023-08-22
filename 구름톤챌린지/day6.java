import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		// 문자열 나누기
		TreeSet<String> sortResult = new TreeSet<>();
		List<String[]> splitResult = new ArrayList<>();
		for (int i = 1; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				String[] str = new String[3];
				str[0] = s.substring(0, i);
				str[1] = s.substring(i, j);
				str[2] = s.substring(j);
				sortResult.add(str[0]);
				sortResult.add(str[1]);
				sortResult.add(str[2]);
				splitResult.add(str);
			}
		}
		
		int max = -1;
		for (String[] str : splitResult) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += (sortResult.headSet(str[i]).size() + 1);
			}
			
			if (max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}
