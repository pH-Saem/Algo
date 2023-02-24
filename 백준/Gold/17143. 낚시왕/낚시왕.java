import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드] 시뮬레이션, 구현
 * 
 * [풀이과정] 1. 낚시왕 객체, 상어 객체 생성 2. 낚시왕 이동 및 상어 겟챠 3. 상어 이동 및 동족상잔 4. 낚시왕이 열 끝까지
 * 이동할 때까지 2~3 반복
 * 
 * [입력] 격자판 크기 R, C와 상어의 수 M 입력 격자판 정보 입력
 * 
 * [출력] 낚시왕이 잡은 상어 크기의 합
 * 
 * @since 2023.
 * @see https://www.acmicpc.net/problem/17143
 * @performance
 * @category #
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;

	static King king;
	static Shark sea[][], tempSea[][], sharks[];
	static int R, C, M; // 격자판 크기 R, C 상어 수 M
	static int deltas[][] = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sea = new Shark[R][C];
		tempSea = new Shark[R][C];
		sharks = new Shark[M];
		king = new King();

		int r, c, s, d, z;
		for (int m = 0; m < M; m++) {
			Shark shark;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			shark = new Shark(r - 1, c - 1, s, d, z, m);
			sharks[m] = shark;
			sea[r - 1][c - 1] = shark;
		}
		
		for(int i = 0; i < C; i++) {
			king.catchShark();
			king.move();
			for(Shark shark : sharks) {
				if(shark != null) {
					shark.move();
				}
			}
			swapSea();
		}
		
		System.out.println(king.score);
	}
	
	static void swapSea() {
		Shark temp[][];
		temp = tempSea;
		tempSea = sea;
		sea = temp;
	}
	
	// 낚시왕 클래스
	static class King {
		int c; 			// 낚시왕의 현재 열
		int score; 		// 지금까지 잡은 상어 크기의 합

		King() {
			this.c = 0;
			this.score = 0;
		}

		void move() {
			this.c++;
		}

		void catchShark() {
			Shark target;
			for (int r = 0; r < R; r++) {
				if (sea[r][this.c] != null) {
					target = sea[r][this.c];
					score += target.size;
					sea[r][this.c] = null;
					sharks[target.index] = null;
					break;
				}
			}
		}
	}

	// 상어 클래스
	static class Shark {
		int r;
		int c;
		int s; 				// 속력
		int d; 				// 방향
		int size; 			// 크기
		int index; 			// sharks 배열의 index
		int trackLength;	// 상,하로 이동하면 R, 좌,우로 이동하면 C

		public Shark(int r, int c, int s, int d, int size, int index) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.size = size;
			this.index = index;
			
			if (d == UP || d == DOWN) {
				this.trackLength = R;
			} else if (d == RIGHT || d == LEFT) {
				this.trackLength = C;
			}
		}

		// 상어 이동시키는 메서드
		void move() {
			int moveAmount ,nr = this.r, nc = this.c;
			
			moveAmount = s % (trackLength * 2 - 2); 			// 왕복하고 남은 이동 횟수

			while(moveAmount != 0) {
				if(isUnderTheSea(nr + deltas[d][0], nc + deltas[d][1]) == false) {
					d = d%2 == 0 ? d - 1 : d + 1;
				}
				nr += deltas[d][0];
				nc += deltas[d][1];
				moveAmount--;
			}
			
			sea[r][c] = null;							// 원래 있던 자리 비운다.
			r = nr; c = nc;								// 위치 갱신
			
			if (tempSea[nr][nc] != null) {				// 이동한 위치에 다른 상어가 있는 경우
				fight(tempSea[nr][nc]);					// 큰 놈이 작은 놈을 잡아먹는다.
			}else {
				tempSea[nr][nc] = this;					// 새로운 자리에 배치한다.
			}
		}

		void fight(Shark shark) {						// 같은 위치에 있는 경우 둘 중 큰 상어가 잡아먹는다.
			if (this.size > shark.size) { 				// 이 상어가 큰 경우 원래 있던 상어 제거
				sharks[shark.index] = null; 			// sharks에서 제거
				tempSea[shark.r][shark.c] = this; 		// sea에서도 제거 및 이 상어가 들어간다.
			} else {
				sharks[this.index] = null;				// sharks에서 이 상어 제거
														// 원래 있던 상어 그대로 둔다.
			}
		}
		
		boolean isUnderTheSea(int r, int c) {
			return 0 <= r && r < R && 0 <= c && c < C;
		}
	}
}