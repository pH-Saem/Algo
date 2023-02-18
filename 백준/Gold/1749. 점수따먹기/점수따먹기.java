import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static long arr[][], area, max, num;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1][M+1];
		
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++) {
				num = Long.parseLong(st.nextToken());
				arr[r][c] = num + arr[r-1][c] + arr[r][c-1] -arr[r-1][c-1];
			}
		}
		
		// r1, c1 : 우하단 좌표 r2, c2 : 좌상단 좌표
		max = Long.MIN_VALUE;
		for(int r1 = 1; r1 <= N; r1++) {
			for(int c1 = 1; c1 <= N; c1++) {
				for(int r2 = 1; r2 <= r1; r2++) {
					for(int c2 = 1; c2 <= c1; c2++) {
						area = arr[r1][c1] - arr[r2-1][c1] - arr[r1][c2-1] + arr[r2-1][c2-1];
						max = Long.max(max, area);
					}
				}
			}
		}
		
		System.out.println(max);
	}

}