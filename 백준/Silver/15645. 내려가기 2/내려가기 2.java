import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 박한샘
 * @since 2023. 2. 18
 * @see https://www.acmicpc.net/problem/2096
 * @performance 39712 kb 316 ms
 * @category #DP #슬라이딩 윈도우?
 */

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static final int SIZE = 3;
	
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int inputs[] = new int[SIZE];
	static int mins[] = new int[SIZE];
	static int maxs[] = new int[SIZE];
	static int tempMins[] = new int[SIZE], tempMaxs[] = new int[SIZE];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int line = 0; line < N; line++) {
			// 다음 줄 정보 입력
			st = new StringTokenizer(br.readLine());
			for(int index = 0; index < SIZE; index++) {
				inputs[index] = Integer.parseInt(st.nextToken());				
			}
			
			// 현재 줄에 이전 줄의 최대, 최소 정보를 더해준다.
			for(int index = 0; index < SIZE; index++) {
				tempMins[index] = inputs[index] + getMinScore(index);
				tempMaxs[index] = inputs[index] + getMaxScore(index);
			}
			
			// mins, maxs 배열 갱신
			swapMinsAndMaxs();
		}
		
		// 최대값, 최소값 구하기
		for(int i = 0; i < SIZE; i++) {
			min = Integer.min(min, mins[i]);
			max = Integer.max(max, maxs[i]);
		}
		
		System.out.println(max + " " + min);
	}
	
	public static void swapMinsAndMaxs() {
		int temp[];
		temp = mins;
		mins = tempMins;
		tempMins = temp;
		
		temp = maxs;
		maxs = tempMaxs;
		tempMaxs = temp;
	}
	
	public static int getMinScore(int index) {
		int left = index - 1, mid = index, right = index + 1;
		int min = mins[mid];

		if(isInRange(left))
			min = Integer.min(min, mins[left]);
		if(isInRange(right))
			min = Integer.min(min, mins[right]);
		
		return min;		
	}
	
	public static int getMaxScore(int index) {
		int left = index - 1, mid = index, right = index + 1;
		int max = maxs[mid];

		if(isInRange(left))
			max = Integer.max(max, maxs[left]);
		if(isInRange(right))
			max = Integer.max(max, maxs[right]);
		
		return max;		
	}
	
	public static boolean isInRange(int index) {
		return index >= 0 && index < SIZE;
	}
}