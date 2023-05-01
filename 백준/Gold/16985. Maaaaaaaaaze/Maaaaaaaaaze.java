import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int[][][] floors;
	static int minCount = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		init();
		solution();
	}

	static void init() throws IOException {
		floors = new int[5][5][5];

		for (int h = 0; h < 5; h++) {
			for (int r = 0; r < 5; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 5; c++) {
					floors[h][r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}

	static void solution() {
		makeRotatePermutation(0);
		if (minCount == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minCount);
	}

	static void makeRotatePermutation(int nthChoice) {
		if (nthChoice == 5) {
			int[][][] maze = new int[5][5][5];
			makeFloorPermutation(0, maze, new boolean[5]);
			return;
		}

		for (int i = 0; i < 4; i++) {
			makeRotatePermutation(nthChoice + 1);
			floors[nthChoice] = rotate90(floors[nthChoice]);
		}
	}
	
	static void makeFloorPermutation(int nthChoice, int[][][] maze, boolean[] isUsed) {
		if(nthChoice == 5) {
			bfs(maze);
			return;
		}
		
		for(int i = 0; i < 5; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				maze[nthChoice] = floors[i];
				makeFloorPermutation(nthChoice + 1, maze, isUsed);
				isUsed[i] = false;
			}
		}
	}
	

	static void bfs(int[][][] maze) {
		boolean isFound = false;
		int[][] deltas = { { 0, 1, 0 }, { 0, 0, 1 }, { 0, -1, 0 }, { 0, 0, -1 }, { 1, 0, 0 }, { -1, 0, 0 } };
		boolean[][][] visited = new boolean[5][5][5];
		Queue<Position> queue = new ArrayDeque<>();

		if (maze[0][0][0] == 0)
			return;

		visited[0][0][0] = true;
		queue.offer(new Position(0, 0, 0));

		Position cur;
		int size, nfloor, nr, nc, count = 0;
		outer: while (!queue.isEmpty()) {
			size = queue.size();

			for (int i = 0; i < size; i++) {
				cur = queue.poll();
				if (cur.floor == 4 && cur.r == 4 && cur.c == 4) {
					isFound = true;
					break outer;
				}

				for (int d = 0; d < 6; d++) {
					nfloor = cur.floor + deltas[d][0];
					nr = cur.r + deltas[d][1];
					nc = cur.c + deltas[d][2];

					if (isInRange(nfloor, nr, nc) && !visited[nfloor][nr][nc] && maze[nfloor][nr][nc] == 1) {
						visited[nfloor][nr][nc] = true;
						queue.offer(new Position(nfloor, nr, nc));
					}
				}
			}

			count++;
		}

		if (isFound)
			minCount = Integer.min(minCount, count);
	}

	static boolean isInRange(int floor, int r, int c) {
		return 0 <= floor && floor < 5 && 0 <= r && r < 5 && 0 <= c && c < 5;
	}

	static int[][] rotate90(int[][] floor) {
		int[][] rotated = new int[5][5];

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				rotated[r][c] = floor[4 - c][r];
			}
		}

		return rotated;
	}

	static class Position {
		int floor;
		int r;
		int c;

		public Position(int floor, int r, int c) {
			this.floor = floor;
			this.r = r;
			this.c = c;
		}
	}
}