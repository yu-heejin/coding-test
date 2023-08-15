import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int w = Integer.parseInt(input[0]);
		int r = Integer.parseInt(input[1]);
		
		System.out.println((int)(w * (1 + (r / 30.0))));
	}
}
