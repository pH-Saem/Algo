import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, K, min = Integer.MAX_VALUE;
	static int origin[][], arr[][], permutation[], dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
	static RotationInfo rInfo[];
	
	static class RotationInfo{
		int r;
		int c;
		int s;
	}
	
	public static void main(String[] args) throws IOException {
		// 배열 크기 N, M 회전 연산의 회수 K 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 배열 생성 및 값 입력
		arr = new int[N+1][M+1];
		origin = new int[N+1][M+1];
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++) {
				origin[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 회전 연산 정보 입력
		permutation = new int[K];
		rInfo = new RotationInfo[K];
		RotationInfo info;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			info = new RotationInfo();
			info.r = Integer.parseInt(st.nextToken());
			info.c = Integer.parseInt(st.nextToken());
			info.s = Integer.parseInt(st.nextToken());
			rInfo[i] = info;
			permutation[i] = i;
		}
		
		// 회전 명령 순열 생성
		do {
			// 순열 순서대로 회전 진행
			copyFromOriginToArr();
			for(int i = 0; i < K; i++) {
				info = rInfo[permutation[i]];
				rotate(info.r, info.c, info.s);
			}
			// 최솟값 계산 및 갱신
			min = Integer.min(min, getMinRowSum());
		}while(nextPermutation());
		
		// 최솟값 출력
		System.out.println(min);
	}
	
	public static void copyFromOriginToArr() {
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				arr[r][c] = origin[r][c];
			}
		}
	}
	
	// 각 행 별로 합을 구하고 최솟값 반환
	public static int getMinRowSum() {
		int sum, result = Integer.MAX_VALUE;
		for(int r = 1; r <= N; r++) {
			sum = 0;
			for(int c = 1; c <= M; c++) {
				sum += arr[r][c];
			}
			result = Integer.min(result, sum);
		}
		return result;
	}
	
	// 배열 회전
	public static void rotate(int r, int c, int s) {
		int sr = r-s, sc = c-s;
		int br = r+s, bc = c+s;
		int nr = sr, nc = sc;
		int prev, cur;
		
		if(s == 0) return;
		prev = arr[sr][sc];
		for(int d = 0; d < 4; d++) {
			while(true) {
				nr += dr[d];
				nc += dc[d];
				if(nr < sr || nr > br || nc < sc || nc > bc) {
					nr -= dr[d];
					nc -= dc[d];
					break;
				}
				cur = arr[nr][nc];
				arr[nr][nc] = prev;
				prev = cur;
			}
		}
		
		rotate(r, c, s-1);
	}
	
	public static boolean nextPermutation() {
		int lastPeak = K - 1;
		while(lastPeak > 0 && permutation[lastPeak-1] >= permutation[lastPeak]) lastPeak--;
		if(lastPeak == 0)
			return false;
		
		int swapTarget = K - 1;
		while(permutation[lastPeak-1] >= permutation[swapTarget]) swapTarget--;
		
		swap(lastPeak-1, swapTarget);
		
		for(int left = lastPeak, right = K - 1; left < right;) {
			swap(left++, right--);
		}
		
		return true;
	}
	
	public static void swap(int i1, int i2) {
		int temp = permutation[i1];
		permutation[i1] = permutation[i2];
		permutation[i2] = temp;
	}
	
}