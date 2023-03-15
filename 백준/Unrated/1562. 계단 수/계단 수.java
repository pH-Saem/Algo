import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author phsaem
 * @since 2023. 3. 15
 * @see https://www.acmicpc.net/problem/1562
 * @performance 
 * @category 
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int[][][] DP;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		// 초기화
		DP = new int[N+1][10][1024];
		for(int i = 1; i < 10; i++) {
			DP[1][i][1 << i] = 1;
		}
		
		int temp;
		for(int i = 1; i < N; i++) {
			// 마지막 자리수가 j인 경우
			for(int j = 0; j < 10; j++) {
				for(int status = 1; status < 1024; status++) {
					if(j == 0) {
						temp = DP[i+1][j+1][status | 1 << (j+1)] + DP[i][j][status];
						if(temp > 1_000_000_000) temp = temp % 1_000_000_000;
						
						DP[i+1][j+1][status | 1 << (j+1)] = temp;
					}
					else if(j == 9) {
						temp = DP[i+1][j-1][status | 1 << (j-1)] + DP[i][j][status];
						if(temp > 1_000_000_000) temp = temp % 1_000_000_000;
						
						DP[i+1][j-1][status | 1 << (j-1)] = temp;
					}else {
						temp = DP[i+1][j-1][status | 1 << (j-1)] + DP[i][j][status];
						if(temp > 1_000_000_000) temp = temp % 1_000_000_000;
						
						DP[i+1][j-1][status | 1 << (j-1)] = temp;
						
						temp = DP[i+1][j+1][status | 1 << (j+1)] + DP[i][j][status];
						if(temp > 1_000_000_000) temp = temp % 1_000_000_000;
						
						DP[i+1][j+1][status | 1 << (j+1)] = temp;
					}
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < 10; i++) {
			result += DP[N][i][1023];
			if(result > 1_000_000_000)
				result = result % 1_000_000_000;
		}
		
		System.out.println(result);
	}

}