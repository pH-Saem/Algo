import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, K;
	static int[][] map;

	static class Position {
		int r;
		int c;
		int breakCount;

		Position(int r, int c, int breakCount) {
			this.r = r;
			this.c = c;
			this.breakCount = breakCount;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		solution();
	}

	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
	}

	public static void solution() {
		int[][] deltas = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		boolean[][][] visited = new boolean[N][M][K+1];
		Queue<Position> queue = new ArrayDeque<>();

		visited[0][0][K] = true;
		queue.offer(new Position(0, 0, K));
		
		Position cur;
		int nr, nc, size, count = 1;
		boolean isFound = false;
		outer : while (!queue.isEmpty()) {
			size = queue.size();

			for (int i = 0; i < size; i++) {
				cur = queue.poll();
				
				if(cur.r == N-1 && cur.c == M-1) {
					isFound = true;
					break outer;
				}
				
				for (int d = 0; d < 4; d++) {
					nr = cur.r + deltas[d][0];
					nc = cur.c + deltas[d][1];
					
					if(isInRange(nr, nc)) {
						if(map[nr][nc] == 1 && cur.breakCount > 0 && !visited[nr][nc][cur.breakCount - 1]) {
							visited[nr][nc][cur.breakCount - 1] = true;
							queue.offer(new Position(nr, nc, cur.breakCount - 1));
						}
						if(map[nr][nc] == 0 && !visited[nr][nc][cur.breakCount]) {
							visited[nr][nc][cur.breakCount] = true;
							queue.offer(new Position(nr, nc, cur.breakCount));
						}
					}
				}
			}
			
			count++;
		}
		
		if(isFound)
			System.out.println(count);
		else
			System.out.println(-1);
	}

	public static boolean isInRange(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}