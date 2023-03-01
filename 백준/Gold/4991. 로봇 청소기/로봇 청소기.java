import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * BFS, 완전탐색, 백트레킹
 * 
 * [풀이과정] 
 * 
 * 1. 로봇청소기와 모든 더러운칸을 시작점으로 BFS로 돌려
 * 각 지점에 대해 최단 경로를 구한다.
 * 2. 1에서 구한 최단 경로로 그래프를 만든다.
 * (모든 점이 연결되어 있어야 한다 -> 완전 그래프)
 * (정점이 최대 11칸이므로 인접행렬로)
 * 3. 그래프로 최소 신장 트리 만들자.
 * 4. 최소 가중치 출력
 * 
 * [입력] 
 * 방 가로 크기 w, 세로 크기 h (1 <= w, h <= 20)
 * 방 정보
 * 
 * [출력] 
 * 최소 이동 횟수
 * 
 * @since 2023. 
 * @see 
 * @performance 
 * @category 
 */
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static final int CLEAN_AREA = '.', ROBOT_CLEANER = 'o', DIRTY_AREA = '*', FURNITURE = 'x';
	
	static int h, w, minMoveCnt;
	static int map[][] = new int[20][20];				// 0 : 깨끗한 칸 1 : 로봇청소기 -1 : 가구 2~: 더러운 칸
	static int graph[][];								// 0은 로봇청소기. 그 뒤로는 더러운칸.
	static Queue<Position> queue = new ArrayDeque<>();	// bfs에서 사용되는 queue
	static Position vertex[] = new Position[12];		// 정점 위치 저장 + 이 인덱스가 그래프의 인덱스
	// 로봇청소기가 1부터 시작하는 map과 맞추기 위해 0번 index 사용하지 않음.
	static int vertexCnt;								// 정점 총 개수
	static int deltas[][] = {{1, 0}, {0 ,1}, {-1, 0}, {0, -1}};
	
	static int permutation[];
	static boolean isSelected[];
	
	public static void main(String[] args) throws IOException {
		while(true) {
			// h, w 입력
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;

			clean();
			output.append(minMoveCnt).append("\n");
		}
		System.out.println(output);
	}

	static void clean() throws IOException {
		// 초기화
		vertexCnt = 1;
		minMoveCnt = Integer.MAX_VALUE;
		
		// 방 정보 입력
		String line; 
		char ch;
		
		for(int r = 0; r < h; r++) {
			line = br.readLine();
			
			for(int c = 0; c < w; c++) {
				ch = line.charAt(c);
				
				if(ch == CLEAN_AREA) {
					map[r][c] = 0;
				}else if(ch == ROBOT_CLEANER) {
					map[r][c] = 1;
					vertex[1] = new Position(r, c);
				}else if(ch == DIRTY_AREA) {
					map[r][c] = ++vertexCnt;
					vertex[vertexCnt] = new Position(r, c);
				}else if(ch == FURNITURE) {
					map[r][c] = -1;
				}
			}
		}
		
//		printMap();
		
		// 모든 정점을 시작점으로 bfs를 통해 각 정점에 이르는 최단경로 구하고
		// 이를 이용하여 그래프 만들기 
		// 그래프 초기화 해주자.
		graph = new int[vertexCnt+1][vertexCnt+1];
		Position p;
		for(int i = 1; i <= vertexCnt; i++) {
			p = vertex[i];
			bfs(p.r, p.c, i);
		}
		
//		printGraph();
		if(isDisconnected() == true) {
			minMoveCnt = -1;
		}else {
			permutation = new int[vertexCnt + 1];
			isSelected = new boolean[vertexCnt + 1];
			
			permutation[0] = 1;
			makePermutation(1, 0);
		}
	}
	
	static boolean isDisconnected() {
		for(int r = 1; r <= vertexCnt; r++) {
			for(int c = 1; c <= vertexCnt; c++) {
				if(r != c && graph[r][c] == 0)
					return true;
			}
		}
		return false;
	}
	
	static void makePermutation(int nthChoice, int moveCnt) {
		if(nthChoice == vertexCnt) {
			minMoveCnt = Integer.min(minMoveCnt, moveCnt);
			return;
		}
		
		int prev = permutation[nthChoice - 1];
		for(int i = 2; i <= vertexCnt; i++) {
			if(isSelected[i] == false && minMoveCnt > moveCnt + graph[prev][i]) {
				isSelected[i] = true;
				permutation[nthChoice] = i;
				makePermutation(nthChoice + 1, moveCnt + graph[prev][i]);
				isSelected[i] = false;
			}
		}
	}
	
	static void printGraph() {
		System.out.println("Graph");
		for(int r = 1; r <= vertexCnt; r++) {
			for(int c = 1; c <= vertexCnt; c++) {
				System.out.printf("%3d", graph[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void printMap() {
		System.out.println("Map");
		for(int r = 0; r < h; r++) {
			for(int c = 0; c < w; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void bfs(int r, int c, int v) {
		Position p;
		int nr, nc;
		boolean visited[][] = new boolean[h][w];
		
		// 초기화
		queue.clear();
		
		visited[r][c] = true;
		queue.offer(new Position(r, c));
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			for(int d = 0; d < 4; d++) {
				nr = p.r + deltas[d][0];
				nc = p.c + deltas[d][1];

				// 범위 안에 있고 아직 방문하지 않은 경우
				if(isInRange(nr, nc) && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					// 맵 확인 (정점이면 그래프에 정보 갱신)
					if(map[nr][nc] > 0) {
//						System.out.println("v : " + v  + "to : " + map[nr][nc] + " w : " + (p.dist + 1));
						graph[v][map[nr][nc]] = p.dist + 1;
					}
					if(map[nr][nc] >= 0) 
						queue.offer(new Position(nr, nc, p.dist + 1));
				}
			}
		}
	}
	
	static boolean isInRange(int r, int c) {
		return 0 <= r && r < h && 0 <= c && c < w;
	}
	
	static class Position{
		int r;
		int c;
		int dist;
		
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
			dist = 0;
		}
		
		public Position(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
	}
}