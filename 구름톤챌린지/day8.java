import java.io.*;
import java.util.*;

class Main {
	
	private static final int[] items = { 14, 7, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		int itemIndex = 0;
		int itemCount = 0;
		while (n > 0) {
			if (items[itemIndex] <= n) {
				n -= items[itemIndex];
				itemCount++;
			} else {
				itemIndex++;
			}
		}
		
		System.out.println(itemCount);
	}
}
