import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 완전 탐색, 부분 집합
 * 
 * [풀이과정] 
 * 1. 각 정점별로 3가지 경우의 수 => 0 : 둘 다 있음 1 : 우변 없음 2 : 밑변 없음
 * 2. 모든 정점에 대해 3가지 경우 최대 총 3^16가지 경우의 수 확인
 * 3. 각각의 경우에 대해 합 구하고 최대값 갱신
 * 4. 최대값 출력
 * 
 * [입력] 
 * 종이조각 세로 크기 N, 가로 크기 M
 * 종이조각 정보
 * 
 * [출력] 
 * 점수의 최대값
 * 
 * @since 2023. 
 * @see 
 * @performance 
 * @category 
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String line; 
	
	static int N, M, max = Integer.MIN_VALUE;
	static int paper[][], status[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		// 종이 조각 세로 N, 가로 M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 초기화
		paper = new int[N+1][M+1];
		status = new int[N+1][M+1];
		
		// 종이 조각 정보 입력
		for(int r = 1; r <= N; r++) {
			line = br.readLine();
			for(int c = 1; c <= M; c++) {
				paper[r][c] = line.charAt(c-1) - '0';
			}
		}
		
		makeSubSet(0);
		System.out.println(max);
	}
	
	static void makeSubSet(int nthCheck) {
		if(nthCheck == N*M) {
			max = Integer.max(max, calc());
			return;
		}
		
		int r = nthCheck / M + 1;
		int c = nthCheck % M + 1;
		
		// 불가능한 경우!
		if(status[r-1][c] == 2 && status[r][c-1] == 1) return;
		
		for(int i = 0; i < 3; i++) {
			if(status[r-1][c] == 2 && i == 1)	// 위쪽이 밑변이 없으면 여기는 우변이 없을 수 없다!
				continue;
			if(status[r][c-1] == 1 && i == 2)	// 왼쪽이 우변이 없으면 여기는 밑변이 없을 수 없다!
				continue;
			if(r == N && i == 2)				// 마지막 행은 밑변이 없을 수 없다!
				continue;
			if(c == M && i == 1)				// 마지막 열은 밑변이 없을 수 없다!
				continue;
			
			status[r][c] = i;
			makeSubSet(nthCheck + 1);
		}
	}
	
	static int calc() {
		int result = 0;
		visited = new boolean[N+1][M+1];
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				if(visited[r][c] == false) {
					visited[r][c] = true;
					if(status[r][c] == 0) {				// 꽉 막힌 경우 그 값만 더한다!
						result += paper[r][c];
					}else if(status[r][c] == 1) { 		// 우변이 없는 경우 가로로 쭉!
						result += sum(r, c, true);
					}else {								// 밑변이 없는 경우 세로로 쭉!
						result += sum(r, c, false);
					}
				}
			}
		}
		
		return result;
	}
	
	// isRow : 가로로 더할건지. 세로로 더할건지
	static int sum(int r, int c, boolean isRow) {
		int sum = 0;
		int dr = isRow ? 0 : 1;
		int dc = isRow ? 1 : 0;
		
		while(status[r][c] != 0) {
			sum = sum*10 + paper[r][c];
			visited[r][c] = true;
			r += dr;
			c += dc;
		}
		
		// 마무리는 항상 0으로 끝나야 한다.
		// 따라서 범위 밖으로 나가는 경우가 없다!!!
		// 마지막도 더해준다!
		visited[r][c] = true;
		sum = sum*10 + paper[r][c];
		
		return sum;
	}
	
	static void printPaper() {
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				System.out.print(paper[r][c]);
			}
			System.out.println();
		}
	}
	
	static void printStatus() {
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				System.out.print(status[r][c]);
			}
			System.out.println();
		}
	}

}