import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] taste = new int[n];
		
		// '가장 높은 재료를 기준'으로 위랑 아래로 '갈수록' 재료의 맛의 정도가 감소하거나 같아야한다.
		// 즉, 가운데를 기준으로 왼쪽은 오름차순, 오른쪽은 내림차순
		
		// 가장 맛있는 햄버거 맛 찾기
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < n; i++) {
			int flavor = Integer.parseInt(temp[i]);
			
			if (flavor > max) {
				max = flavor;
				maxIndex = i;
			}
			
			taste[i] = flavor;
		}
		
		// 가장 맛있는 햄버거를 기준으로 왼쪽과 오른쪽을 나눈다.
		int[] left = Arrays.copyOfRange(taste, 0, maxIndex);
		int[] right = Arrays.copyOfRange(taste, maxIndex + 1, n);
		
		if (isUpSorted(left, max) && isDownSorted(right, max)) {
			System.out.println(getSum(left) + getSum(right) + max);
		} else {
			System.out.println(0);
		}
	}
	
	private static boolean isUpSorted(int[] arr, int max) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > max) {
				return false;
			}
			
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isDownSorted(int[] arr, int max) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > max) {
				return false;
			}
			
			if (arr[i] < arr[i + 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static int getSum(int[] arr) {
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
}
