import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int w, h, count, map[][], visited[][];
	static int dr[] = {1, 0, -1, 0, 1, 1, -1, -1}, dc[] = {0, 1, 0, -1, 1, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			count = 0;
			
			if(w == 0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visited = new int[h][w];
			
			for(int r = 0; r < h; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < w; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for(int r = 0; r < h; r++) {
				for(int c = 0; c < w; c++) {
					if(visited[r][c] == 0  && map[r][c] == 1) {
						count++;
						dfs(r, c);
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void dfs(int r, int c) {
		int nr, nc;
		visited[r][c] = 1;
		for(int d = 0; d < dr.length; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(isIn(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] == 1)  {
				dfs(nr, nc);
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < h && c >= 0 && c < w;
	}
}
