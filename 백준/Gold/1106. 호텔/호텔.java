import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int C, N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		dp = new int[C + 200];
		Arrays.fill(dp, 1_000_000_000);

		dp[0] = 0;
		
		int cost, interval;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cost = Integer.parseInt(st.nextToken());
			interval = Integer.parseInt(st.nextToken());
			
			for(int j = 0, length = dp.length; j < length; j++) {
				if(j - interval < 0) continue;
				else if(dp[j] > dp[j - interval] + cost) {
					dp[j] = dp[j - interval] + cost;
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = C, length = dp.length; i < length; i++) {
			min = Integer.min(min, dp[i]);
		}
		
		System.out.println(min);
	}

}