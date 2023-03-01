import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 완전 탐색, 조합
 * 
 * [풀이과정] 
 * 0. 선생님 클래스 생성
 * 1. 복도 정보 입력 및 선생님 인스턴스 생성
 * 2. 선생님 시야 범위에 있는 공간 좌표 저장
 * 3. 조합으로 선생님 시야 범위에 있는 공간들 중 3곳 선택
 * 4. 선생님 감시 ON
 * 5. 학생 발견 시 다음 조합으로 넘어가기
 * 6. 학생 발견하지 못 한 경우 성공
 * 7. 모든 조합에 대해 4~6 반복
 * 8. 결과 출력
 * 
 * [입력] 
 * 복도 크기 N 입력
 * 복도 정보 입력
 * 
 * [출력] 
 * 감시 피할 수 있는지 여부
 * 
 * @author 박한샘
 * @since 2023. 3. 1
 * @see https://www.acmicpc.net/problem/18428
 * @performance 
 * @category 
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int VOID = 0, STUDENT = 1, TEACHER = 2, OBSTACLE = -1;
	
	static int N, map[][], deltas[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static boolean isSuccess;
	static List<Teacher> teachers = new ArrayList<>();
	static List<Position> obstacles = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 복도 크기 N 입력
		N = Integer.parseInt(br.readLine());
		
		// 복도 정보 입력
		char ch;
		map = new int[N][N];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				ch = st.nextToken().charAt(0);
				if(ch == 'X') {
					map[r][c] = VOID;
				}else if(ch == 'S') {
					map[r][c] = STUDENT;
				}else if(ch == 'T') {
					map[r][c] = TEACHER;
					teachers.add(new Teacher(r, c));
				}
			}
		}
		
		// 장애물 후보 생성
		for(Teacher t : teachers) {
			updateObstacles(t.r, t.c);
		}
		
//		printInfos();
		
		// 조합으로 장애물 후보에서 3개 선택
		makeCombination(0, 0, new int[3]);
		
		if(isSuccess == true) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	
	static void makeCombination(int nthChoice, int startIdx, int choosed[]) {
		if(isSuccess == true) return;
		
		if(nthChoice == 3) {
//			System.out.println(Arrays.toString(choosed));
			boolean isFound = false;
			setObstacles(choosed, false);		// 장애물 설치
			for(Teacher t : teachers) {			// 모든 선생님 감시 ON
				if(t.watch() == true) {			// 발견되면 실패!
					isFound = true;
					break;
				}
			}
			
			if(isFound == false) {				// 모든 선생님이 감시했는데 발견되지 않았다!
				isSuccess = true;				// 자유!
			}
			
			setObstacles(choosed, true);		// 장애물 제거
			return;
		}
		
		for(int i = startIdx, size = obstacles.size(); i < size; i++) {
			choosed[nthChoice] = i;
			makeCombination(nthChoice + 1, i + 1, choosed);
		}
	}
	
	static void setObstacles(int choosed[], boolean isReset) {
		Position p;
		int value = isReset ? VOID : OBSTACLE;
		for(int index : choosed) {
			p = obstacles.get(index);
			map[p.r][p.c] = value;
		}
	}
	
	// 장애물 위치 후보 추가
	static void updateObstacles(int r, int c) {
		int nr, nc;
		boolean visited[][] = new boolean[N][N];
		for(int d = 0; d < 4; d++) {
			nr = r + deltas[d][0];
			nc = c + deltas[d][1];
			while(isInRange(nr, nc)) {
				if(visited[nr][nc] == false && map[nr][nc] == VOID) {
					visited[nr][nc] = true;
					obstacles.add(new Position(nr, nc));
				}
				nr += deltas[d][0];
				nc += deltas[d][1];
			}
		}
	}
	
	static boolean isInRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

	static class Position{
		int r;
		int c;
		
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + "]";
		}
	}
	
	static class Teacher{
		int r;
		int c;
		
		public Teacher(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		boolean watch() {
			int nr, nc;
			for(int d = 0; d < 4; d++) {
				nr = r + deltas[d][0];
				nc = c + deltas[d][1];
				while(isInRange(nr, nc) && map[nr][nc] != OBSTACLE) {
					if(map[nr][nc] == STUDENT) {
						return true;
					}
					nr += deltas[d][0];
					nc += deltas[d][1];
				}
			}
			return false;
		}

		@Override
		public String toString() {
			return "Teacher [r=" + r + ", c=" + c + "]";
		}
		
	}
	
	static void printInfos() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(teachers);
		System.out.println(obstacles.size());
	}
}