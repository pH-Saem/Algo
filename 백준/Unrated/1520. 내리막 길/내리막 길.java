import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int M, N;
	static int deltas[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	static int[][] map, route;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		route = new int[M][N];
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				route[r][c] = -1;
			}
		}
		
		for(int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
	
		System.out.println(route[0][0]);
	}
	
	static int dfs(int r, int c) {
		if(r == M-1 && c == N-1) return 1;
		int nr, nc, count = 0;
		for(int d = 0; d < 4; d++) {
			nr = r + deltas[d][0];
			nc = c + deltas[d][1];
			
			if(isInRange(nr, nc) && map[r][c] > map[nr][nc]) {
				if(route[nr][nc] != -1) {
					count += route[nr][nc];
				}else {					
					count += dfs(nr, nc);
				}
			}
		}
		route[r][c] = count;
		return count;
	}
	
	static boolean isInRange(int r, int c) {
		return 0 <= r && r < M && 0 <= c && c < N;
	}

}