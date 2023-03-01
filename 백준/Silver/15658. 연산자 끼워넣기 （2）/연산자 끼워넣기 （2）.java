import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 완전탐색, 백트레킹
 * 
 * [풀이과정] 
 * N의 개수는 최대 11개.
 * 선택해야 하는 연산자의 수는 최대 10개
 * 연산자의 종류는 4개
 * 4^10의 경우를 탐색하며 주어진 연산자 개수를 넘어서는 경우 가지치기
 * 
 * [입력] 
 * 수의 개수 N
 * N개의 수
 * +, -, *, / 개수
 * 
 * [출력] 
 * 최댓값
 * 최솟값
 * 
 * @since 2023. 
 * @see https://www.acmicpc.net/problem/15658
 * @performance 
 * @category 
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static final int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3;
	
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int N, nums[];
	static int totalOperCnt[] = new int[4], usedOperCnt[] = new int[4];
	static int selectedOper[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 수의 개수 N 입력
		N = Integer.parseInt(br.readLine());
		
		// N개의 수 입력
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 총 연산자 개수 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			totalOperCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 선택 및 최대, 최소 갱신
		selectedOper = new int[N-1];
		selectOper(0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void selectOper(int nthChoice) {
		// N-1개의 연산자를 모두 선택한 경우
		if(nthChoice == N-1) {
			// 선택한 연산자로 계산 진행
			int result = calc();
			// 결과로 최대 및 최소 갱신
			min = Integer.min(min, result);
			max = Integer.max(max, result);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			// 아직 사용할 수 있는 연산자가 남아있는 경우
			if(usedOperCnt[i] < totalOperCnt[i]) {
				usedOperCnt[i]++;
				selectedOper[nthChoice] = i;
				selectOper(nthChoice + 1);
				usedOperCnt[i]--;
			}
		}
	}

	static int calc() {
		int result = nums[0];
		for(int i = 0; i < N-1; i++) {
			if(selectedOper[i] == PLUS) {
				result = result + nums[i+1];
			}else if(selectedOper[i] == MINUS) {
				result = result - nums[i+1];
			}else if(selectedOper[i] == MUL) {
				result = result * nums[i+1];
			}else if(selectedOper[i] == DIV) {
				result = result / nums[i+1];
			}
		}
		return result;
	}
}