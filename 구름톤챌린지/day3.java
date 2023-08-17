import java.io.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < t; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[2]);
			String op = input[1];
			
			switch (op) {
				case "+":
					sum += (a + b);
					break;
				
				case "-": 
					sum += (a - b);
					break;
				
				case "*":
					sum += (a * b);
					break;
					
				case "/":
					sum += (a / b);
					break;
			}
		}
		
		System.out.println(sum);
	}
}
