import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우의 정석같은 문제
 * @author 박한샘
 * @since 2023. 2. 17
 * @see https://www.acmicpc.net/problem/2531
 * @performance 16376 kb 140 ms
 * @category #슬라이딩 윈도우 #투포인터
 */

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N; 				// 접시의 수
	static int d; 				// 초밥의 가짓수
	static int k; 				// 연속해서 먹는 접시의 수 (슬라이딩 윈도우 크기)
	static int c; 				// 쿠폰 번호
	static int circleOfSushi[];	// 회전 초밥
	static int counts[]; 		// 슬라이딩 윈도우의 범위 안에 있는 초밥 종류 및 수 저장 (인덱스 = 초밥번호)
	static int count;			// 슬라이딩 윈도우 안의 초밥 종류 수
	static int max;				// 먹을 수 있는 초밥 가짓수의 최댓값

	public static void main(String[] args) throws IOException {
		// N, d, k, c 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// 초기화
		circleOfSushi = new int[N];
		counts = new int[d+1];
		
		// 초밥 종류 입력 및 k 크기의 슬라이딩 윈도우 생성
		int size = 0, num;							// size : 현재 슬라이딩 윈도우 크기 num : 초밥종류 임시 저장
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(br.readLine());
			circleOfSushi[i] = num;
			if(size != k) {							// k 크기의 슬라이딩 윈도우 생성
				size++;
				if(counts[num] == 0) count++;		// 0 인 경우 새로운 초밥 종류가 추가된 것.
				counts[num]++;
			}
		}
		
		// 쿠폰 초밥 추가
		if(counts[c] == 0) count++;
		counts[c]++;
		
		max = count;
		
		int left = 0, right = k;					// 슬라이딩 윈도우 왼쪽값(뺄 값)과 오른쪽+1값(더할 값)
		while(left != N) {
			if(right == N) right = 0;
			
			if(counts[circleOfSushi[left++]]-- == 1)
				count--;
			if(counts[circleOfSushi[right++]]++ == 0)
				count++;
			
			max = Integer.max(max, count);
		}
		
		System.out.println(max);
	}

}