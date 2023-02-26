import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;

	static int N;	// 격자 크기 NxN
	static int M;	// 상어 마리 수
	static int k;	// 냄새 지속시간
	static int time;
	static int deltas[][] = {{}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int sharkCount;
	static Shark sharks[];
	static Shark sharksGrid[][];
	static Mark marks[][];
	static boolean isSharkMark[];
	
	public static void main(String[] args) throws IOException {
		// N, M, k 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// 초기화
		sharkCount = M;
		sharks = new Shark[M+1];
		sharksGrid = new Shark[N][N];
		marks = new Mark[N][N];
		isSharkMark = new boolean[M+1];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				marks[r][c] = new Mark();
			}
		}
		
		// 격자 정보 입력
		int num;
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				num = Integer.parseInt(st.nextToken());
				if(num != 0) {								// 상어 생성 및 마킹
					Shark shark = new Shark(r, c, num);
					shark.marking();
					sharks[num] = shark;
					sharksGrid[r][c] = shark;
				}
			}
		}
		
		// 상어 방향 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= M; i++) {
			sharks[i].d = Integer.parseInt(st.nextToken());
		}
		
		// 우선순위 입력
		int priority[][];
		for(int i = 1; i <= M; i++) {
			priority = new int[5][4];
			for(int d = 1; d <= 4; d++) {
				st = new StringTokenizer(br.readLine());
				for(int p = 0; p < 4; p++) {
					priority[d][p] = Integer.parseInt(st.nextToken());
				}
			}
			sharks[i].priority = priority;
		}
		
		// 배틀로얄
		while(time < 1000 && sharkCount != 1) {
			// 상어 이동
			for(Shark shark : sharks) {
				if(shark != null) {
					shark.move();
				}
			}
			
			// 냄새 옅어지기
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					marks[r][c].fade();
				}
			}
			
			updateMarks();
			time++;
		}
		
		if(sharkCount == 1)
			System.out.println(time);
		else
			System.out.println(-1);
	}
	
	static void updateMarks() {
		for(int i = 1; i <= M; i++) {
			if(isSharkMark[i] == true) {
				sharks[i].marking();
				isSharkMark[i] = false;
			}
		}
	}
	
	static class Shark{
		int r;
		int c;
		int d;
		int num;
		int priority[][];
		
		public Shark(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
		
		void move() {
			int nr = r, nc = c, nd = d;
			boolean isFound = false;
			// 1. 이동할 방향 정하기
			// 1-1 아무 마크도 없는 곳(우선순위 순으로 사방탐색)
			for(int i = 0; i < 4; i++) {
				nd = priority[d][i];
				nr = r + deltas[nd][0];
				nc = c + deltas[nd][1];
				if(isInRange(nr, nc) == true && marks[nr][nc].num == 0) {
					isFound = true;
					break;
				}
			}
			// 1-2 내 마크 있는 곳
			if(isFound == false) {
				for(int i = 0; i < 4; i++) {
					nd = priority[d][i];
					nr = r + deltas[nd][0];
					nc = c + deltas[nd][1];
					if(isInRange(nr, nc) == true && marks[nr][nc].num == num) break;
				}
			}
			
			// 2. 이동
			sharksGrid[r][c] = null;				// 이전 위치 비워주기
			r = nr; c = nc; d = nd;
			if(sharksGrid[nr][nc] == null) {		// 2-1. 이동한 곳에 상어 없으면 끝
				sharksGrid[nr][nc] = this;			// 이동
				
				isSharkMark[num] = true;			// 마킹
			}else {									// 2-2. 이동한 곳에 상어 있으면 비교 후 한 마리 내쫓기
				fight(sharksGrid[nr][nc]);
			}
		}
		
		void fight(Shark opponent) {
			sharkCount--;
			if(num < opponent.num) {				// 내가 이겼다!
				int nr = opponent.r, nc = opponent.c;
				sharks[opponent.num] = null;
				sharksGrid[nr][nc] = this; 
				
				isSharkMark[opponent.num] = false; 
				isSharkMark[num] = true;			// 마킹
			}else {									// 졌다! 내가 퇴장...
				sharks[num] = null;
			}
		}
		
		void marking() {
			marks[r][c].setMark(num);
		}
		
		boolean isInRange(int r, int c) {
			return 0 <= r && r < N && 0 <= c && c < N;
		}
		
	}
	
	static class Mark{
		int duration;
		int num;
		
		Mark(){
			duration = 0;
			num = 0;
		}
		
		void setMark(int num) {
			duration = k;
			this.num = num;
		}
		
		void fade() {
			if(duration == 1) {
				num = 0;		// 지속시간 끝나서 마킹 해제
			}
			if(duration >= 1) {
				duration--;
			}
		}
	}
}