import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드]
 * BFS 완전탐색
 * 
 * [풀이과정]
 * 1. 아직 방문하지 않은 모든 가장자리에서 BFS를 돌려서 1시간 후에 없어지는 치즈들을 구한다.
 * 2. 구한 치즈들을 녹이고 녹은 치즈의 사방탐색을 한다.
 * 2-1. 아직 방문 안 한 치즈가 있는 경우 -> 내가 녹음으로 공기에 노출된 치즈. 다음에 녹을 예정. 저장해둔다.
 * 2-2. 아직 방문 안 한 공기가 있는 경우 -> 치즈 내부의 공기. BFS를 돌려서 새로 노출된 치즈를 저장한다.
 * 3. 치즈가 다 녹을 때까지 1-2를 반복한다.
 * 4. 치즈가 다 녹으면 마지막으로 녹인 치즈 개수와 걸린 시간을 출력한다.
 *
 * [입력]
 * 사각형 모양 판의 세로 길이, 가로 길이
 * 판의 정보
 *
 * [출력] 
 * 치즈가 모두 녹는데 걸리는 시간
 * 녹기 한 시간 전에 남아있는 치즈 조각 수
 *
 * @author phsaem
 * @since 2023. 3. 31
 * @see https://www.acmicpc.net/problem/2636
 * @performance 
 * @category #BFS
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int CHEESE = 1, AIR = 0;
	
	static int R, C;
	static int[][] board;
	static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static boolean[][] visited;
	static Queue<int[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new int[R][C];
		visited = new boolean[R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 가장자리에서 BFS로 공기에 노출된 치즈들을 queue에 넣는다.
		for(int r = 0; r < R; r++) {
			if(!visited[r][0])
				airDiffuse(r, 0);
			if(!visited[r][C-1])
				airDiffuse(r, C-1);
		}
		for(int c = 0; c < C; c++) {
			if(!visited[0][c])
				airDiffuse(0, c);
			if(!visited[R-1][c])
				airDiffuse(R-1, c);
		}
		
		// 2. 녹을 치즈들 녹이고! 녹을 치즈들 다시 구하고!
		int size = 0, time = 0, nr, nc, pos[];
		while(!queue.isEmpty()) {
			size = queue.size();	// 이번 시간에 녹을 치즈의 수
			time++;
			
			for(int i = 0; i < size; i++) {
				pos = queue.poll();
				for(int d = 0; d < 4; d++) {
					nr = pos[0] + deltas[d][0];
					nc = pos[1] + deltas[d][1];
					
					if(isInRange(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						if(board[nr][nc] == AIR) {				// 아직 방문 안 한 공기란? 치즈 내부의 공기. BFS 한번 돌려준다.
							airDiffuse(nr, nc);
						}else if(board[nr][nc] == CHEESE) {		// 아직 방문 안 한 치즈란? 다음에 녹을 치즈.
							queue.offer(new int[] {nr, nc});
						}
					}
				}
			}
			
		}
		
		System.out.println(time);
		System.out.println(size);
	}
	
	static void airDiffuse(int r, int c) {
		Queue<int[]> airs = new ArrayDeque<>();
		int nr, nc, pos[];

		airs.offer(new int[] {r, c});
		visited[r][c] = true;
		while(!airs.isEmpty()) {
			pos = airs.poll();
			for(int d = 0; d < 4; d++) {
				nr = pos[0] + deltas[d][0];
				nc = pos[1] + deltas[d][1];
				
				if(isInRange(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if(board[nr][nc] == AIR) {
						airs.offer(new int[] {nr, nc});			// 현재 탐색할 공기
					}else if(board[nr][nc] == CHEESE) {
						queue.offer(new int[] {nr, nc});		// 앞으로 녹일 치즈
					}
				}
			}
		}
	}
	
	static boolean isInRange(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}