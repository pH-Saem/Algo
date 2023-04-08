import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static final int WALL = -1, EMPTY = 0;
	
	static int N, M, count, num = 1;
	static EmptyCluster[][] map;
	static int[][] result;
	static List<int[]> wall;
	static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		input();
		calcEmptySpace();
		calcAnswer();
		printAnswer();
	}
	
	static void printAnswer() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				output.append(result[r][c]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	
	static void calcAnswer() {
		int nr, nc;
		
		Set<EmptyCluster> set = new HashSet<>();
		for(int[] p : wall) {
			count = 1;
			set.clear();
			
			for(int d = 0; d < 4; d++) {
				nr = p[0] + deltas[d][0];
				nc = p[1] + deltas[d][1];
				
				if(isInRange(nr, nc))
					set.add(map[nr][nc]);
			}
			
			set.forEach((emptyCluster)->{
				count += emptyCluster.amount;
			});
			
			result[p[0]][p[1]] = count%10;
		}
	}
	
	static void calcEmptySpace() {
		boolean[][] visited = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(!visited[r][c] && map[r][c] == null) {
					bfs(r, c, visited);
				}
			}
		}
	}
	
	static void bfs(int r, int c, boolean[][] visited) {
		Queue<int[]> queue = new ArrayDeque<>();
		EmptyCluster emptyCluster = new EmptyCluster(num++);
		
		visited[r][c] = true;
		map[r][c] = emptyCluster;
		queue.offer(new int[] {r, c});
		
		int[] cur;
		int nr, nc, count = 1;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				nr = cur[0] + deltas[d][0];
				nc = cur[1] + deltas[d][1];
				
				if(isInRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == null) {
					visited[nr][nc] = true;
					map[nr][nc] = emptyCluster;
					count++;
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		
		emptyCluster.amount = count;
	}
	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		wall = new ArrayList<int[]>();
		result = new int[N][M];
		
		map = new EmptyCluster[N][M];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				if(line.charAt(c) == '0')
					map[r][c] = null;
				else {
					map[r][c] = new EmptyCluster();
					wall.add(new int[] {r, c});
					map[r][c].num = WALL;
				}
			}
		}
	}
	
	static boolean isInRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
	
	static class EmptyCluster{
		int num;
		int amount;
		
		EmptyCluster(){}
		
		EmptyCluster(int num){
			this.num = num;
		}
	}

}