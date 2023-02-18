import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K ,W ,V, dp[][];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());			// 물건 개수
		K = Integer.parseInt(st.nextToken());			// 커틸 수 있는 무게
		
		dp = new int[N+1][K+1];
		
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());		// 물건 무게
			V = Integer.parseInt(st.nextToken());		// 물건 가치
			
			for(int w = 1; w <= K; w++) {
				dp[n][w] = dp[n-1][w];					// n번 째 물건을 넣지 않는 경우
				if(w >= W) {							// 버틸 수 있는 무게 w가 현재 무게 W보다 큰 경우
					dp[n][w] = Integer.max(dp[n][w], dp[n-1][w-W] + V); // n번 째 물건을 챙긴 것이 더 큰 경우
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}