import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 박한샘
 * @since 2023. 2. 5
 * @see https://www.acmicpc.net/problem/13460
 * @performance 16,060 kb , 132 ms
 * @category #구현 #BFS
 */

public class Main {
	static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static char board[][];
	static Queue<MarbleInfo> q = new LinkedList<>();
	static MarbleInfo cur, afterTilt;
	static Marble red = new Marble(), blue = new Marble();
	
	// 파란 구슬과 빨간 구슬의 위치 정보
	// BFS를 돌 때 각 분기의 구슬 정보와 몇 번 기울였는지를 저장할 용도
	static class MarbleInfo{
		Marble red;
		Marble blue;
		int count;
		
		public MarbleInfo() {
			red = new Marble();
			blue = new Marble();
		}
		
		public void copy(MarbleInfo m) {
			setRed(m.red);
			setBlue(m.blue);
			this.count = m.count;
		}
		
		public void setRed(Marble p) {
			red.setMarble(p);
		}
		
		public void setBlue(Marble p) {
			blue.setMarble(p);
		}
		
		// 구슬이 이동했는지 확인하는 메서드
		public boolean isMarbleMoved(MarbleInfo m) {
			return red.isDiff(m.red) || blue.isDiff(m.blue);
		}
	}
	
	// 구슬 정보
	// r, c : 위치 정보 isIn : 해당 구슬이 구멍이 빠졌는 지
	static class Marble{
		int r;
		int c;
		boolean isIn;
		
		public Marble() {}
		
		public Marble(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public void setMarble(Marble p){
			this.r = p.r;
			this.c = p.c;
			isIn = false;
		}
		
		// 두 구슬의 위치가 다른지 확인하는 메서드
		public boolean isDiff(Marble p) {
			return r != p.r || c != p.c;
		}
	}
	
	// 보드를 기울이는 메서드
	// 파라미터로 방향을 받는다.
	public static void tilt(int d) {
		
		// 현재 분기의 정보를 복사한다.
		// tilt는 방향 별로 총 4번 호출되기 때문에 cur 를 그대로 사용하면
		// 다음 tilt가 제대로 동작하지 않을 것이다.
		afterTilt.copy(cur);
		afterTilt.count += 1;
		
		// d의 방향으로 구슬을 움직인다.
		moveMarbles(d);
		// 구슬이 둘 다 구멍에 빠지지 않았으면 한번 더 움직인다.
		// 구슬을 두 번 움직이는 이유
		// 두 구슬이 붙어있고 붙어있는 방향으로 기울일 경우에 처리가 복잡해진다.
		// 따라서 구슬을 하나씩 움직이고 진행방향에 다른 구슬이 있으면 멈추고 다음 구슬을 움직인다.
		// 그 다음 다시 한 번 구슬들을 움직여서 이전에 다른 구슬때문에 움직이지 못한 구슬을 마저 움직인다.
		moveMarbles(d);

	}
	
	// 구슬들을 움직이는 메서드
	// 빨간 구슬을 먼저 이동시킨 후 파란 구슬을 이동시킨다.
	public static void moveMarbles(int d) {
		moveMarble(afterTilt.red, afterTilt.blue, d); // 빨간 구슬 이동
		moveMarble(afterTilt.blue, afterTilt.red, d); // 파란 구슬 이동
	}
	
	// 구슬을 움직이는 메서드
	// param
	// Marble mv : 움직일 구슬 Marble st : 나머지 구슬 int d : 방향
	// 움직일 구슬을 주어진 방향으로 갈 수 있을 때까지 이동시킨다.
	// 움직일 수 없는 경우
	// 1. 벽 '#'에 도달한 경우 2. 다른 구슬이 있는 경우 3. 구멍에 빠진 경우
	public static void moveMarble(Marble mv, Marble st, int d) {
		int dr = deltas[d][1], dc = deltas[d][0];
		
		while(mv.isDiff(st) && board[mv.r][mv.c] != '#') {
			if(board[mv.r][mv.c] == 'O') {
				mv.isIn = true;
				mv.r = 0; // 구멍에 빠진 경우 다른 구슬에 영향을 주지 않기 위해
				mv.c = 0; // (0, 0)으로 설정. (0, 0)은 항상 '#'이므로 while문을 돌지 않는다.
				break;
			}
			mv.r += dr; mv.c += dc;
		}
		
		// 구슬에 빠진 경우를 제외하면
		// while문에서 나오는 경우는 구슬과 겹치거나 벽에 들어간 경우
		// 따라서 뒤로 한 칸 이동한다.
		if(!mv.isIn) {
			mv.r -= dr;
			mv.c -= dc;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M]; // board의 정보. 구슬의 정보는 따로 관리한다. 즉, 벽과 구멍의 정보만 담는다.
		cur = new MarbleInfo(); // 현재 구슬들의 정보
		afterTilt = new MarbleInfo(); // cur에서 보드를 기울인 후의 구슬들의 정보
		
		String line;
		char ch;
		for(int r = 0; r < N; r++) {
			line = br.readLine();
			for(int c = 0; c < M; c++) {
				ch = line.charAt(c);
				if(ch == 'R') {
					cur.setRed(new Marble(r, c));
				}else if(ch == 'B') {
					cur.setBlue(new Marble(r, c));
				}else {
					board[r][c] = ch;
				}
			}
		}
		
		q.add(cur);
		outer : while(!q.isEmpty()) {
			cur = q.poll();
			for(int d = 0; d < deltas.length; d++) { // 4방향으로 보드를 기울인다.
				tilt(d);
				if(afterTilt.isMarbleMoved(cur) && !afterTilt.blue.isIn) { // 구슬이 움직였고 파란구슬이 구멍에 빠지지 않은 경우
					if(afterTilt.red.isIn) { //빨간 구슬만 구멍에 빠진 경우
						System.out.println(1);
						break outer;
					}else if(afterTilt.count < 10){ // 구슬이 움직였고 모든 구슬이 구멍에 빠지지 않고 아직 10번 움직이지 않은 경우
						q.add(afterTilt);
						afterTilt = new MarbleInfo(); // queue에 추가한 경우에만 afterTilt 새로 생성
						// 이외의 경우에는 어차피 queue에 넣지 않을 것이니 재활용한다.
					}
				}
				
				// 구슬이 움직이지 않은 경우는 cur와 다를바 없으므로 queue에 넣지 않는다.
				// 파란 구슬이 빠진 경우도 실패이므로 넣지 않는다.
			}
		}
		
		// BFS가 끝났는데 빨간 구슬이 구멍에 들어가고 파란 구슬은 들어간 경우가 아니라면
		// 실패이므로 -1 출력
		if(!(afterTilt.red.isIn && !afterTilt.blue.isIn)) {
			System.out.println(0);
		}

	}

}