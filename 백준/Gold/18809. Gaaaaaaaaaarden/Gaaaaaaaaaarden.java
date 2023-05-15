import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int GREEN = -1, RED = 1, VISITED = 2, FLOWER = 3;
	
	static int N, M, G, R, maxFlower;
	static int[] red;
	static int[][] gaaaaaaaaaarden;
	static Position[] choosedSoil;
	static List<Position> soil;
	
	public static void main(String[] args) throws IOException {
		init();
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		gaaaaaaaaaarden = new int[N][M];
		choosedSoil = new Position[G+R];					// 조합에 사용될 Position 배열
		red = new int[R];
		soil = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				gaaaaaaaaaarden[r][c] = Integer.parseInt(st.nextToken());
				if(gaaaaaaaaaarden[r][c] == 2) {
					soil.add(new Position(r, c));			// 배양액을 뿌릴 수 있는 땅 저장
				}
			}
		}
	}
	
	static void solution() {
		// 1. G, R 상관없이 배양액을 뿌릴 땅 G+R개 선택
		choiceSoil(0, 0);
		System.out.println(maxFlower);
	}
	
	// 조합
	static void choiceSoil(int nthChoice, int startIdx) {
		if(nthChoice == choosedSoil.length) {
			// 2. 선택한 땅에서 뿌릴 배양액(G, R) 선택
			choiceColor(0, 0);
			return;
		}
		
		for(int i = startIdx; i < soil.size(); i++) {
			choosedSoil[nthChoice] = soil.get(i);
			choiceSoil(nthChoice + 1, i + 1);
		}
	}
	
	static void choiceColor(int nthChoice, int startIdx) {
		if(nthChoice == R) {
			for(Position p : choosedSoil) {
				p.color = GREEN;
			}
			for(int r : red) {
				choosedSoil[r].color = RED;
			}
			
			// 3. 배양하여 피울 수 있는 꽃 최대 개수 갱신
			bfs();
			return;
		}
		
		for(int i = startIdx; i < choosedSoil.length; i++) {
			red[nthChoice] = i;
			choiceColor(nthChoice + 1, i + 1);
		}
	}
	
	static void bfs() {
		Queue<Position> queue = new ArrayDeque<>();
		Queue<Position> visited = new ArrayDeque<>();
		int[][] gardenColor = new int[N][M];
		int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		for(Position p : choosedSoil) {
			queue.offer(p);
			gardenColor[p.r][p.c] = VISITED; 
		}
		
		Position cur;
		int nr, nc, size, flowerCount = 0;
		while(!queue.isEmpty()) {
			size = queue.size();
			
			for(int i = 0; i < size; i++) {
				cur = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					nr = cur.r + deltas[d][0];
					nc = cur.c + deltas[d][1];
					
					if(isInRange(nr, nc) && gaaaaaaaaaarden[nr][nc] != 0) {
						if(gardenColor[nr][nc] == 0) {
							gardenColor[nr][nc] = cur.color;
							visited.offer(new Position(nr, nc, cur.color));
						}else if(gardenColor[nr][nc] * cur.color == -1) {
							gardenColor[nr][nc] = FLOWER;
							flowerCount++;
						}
					}
				}
			}
			
			while(!visited.isEmpty()) {
				cur = visited.poll();
				if(gardenColor[cur.r][cur.c] != FLOWER) {
					gardenColor[cur.r][cur.c] = VISITED;
					queue.offer(cur);
				}
			}
		}
		
		maxFlower = Integer.max(maxFlower, flowerCount);
	}
	
	static boolean isInRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}

	static class Position{
		int r;
		int c;
		int color;
		
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Position(int r, int c, int color) {
			this.r = r;
			this.c = c;
			this.color = color;
		}
	}
}