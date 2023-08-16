import java.io.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] times = br.readLine().split(" ");
		int h = Integer.parseInt(times[0]);
		int m = Integer.parseInt(times[1]);
		
		for (int i = 1; i <= n; i++) {
			if (m >= 60) {
				int timeForAdd = m / 60;
				int timeForChange = m % 60;
				
				m = timeForChange;
				h += timeForAdd;
			}
			
			if (h > 23) {
				h %= 24;
			}

			m += Integer.parseInt(br.readLine());
		}
		
		if (m >= 60) {
				int timeForAdd = m / 60;
				int timeForChange = m % 60;
				
				m = timeForChange;
				h += timeForAdd;
			}
			
			if (h > 23) {
				h %= 24;
			}
		
		System.out.println(h + " " + m);
	}
}
