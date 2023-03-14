import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 슬라이딩 윈도우
 * 
 * [풀이과정] 
 * 1. 라이언 인형이 등장한 인덱스 저장
 * 2. 해당 인덱스들 이용해서 길이 계산
 * 3. 최소값 구하기
 * 
 * 시간초과!
 * 1. 라이언 K개 포함하는 슬라이딩 윈도우 만들기
 * 2. K개 되면 라이언 인형이 새로 들어오면 이전 라이언 인형 빼고
 * 다음 라이언 인형 나오기 전까지 빼기
 * 3. 최소 길이 갱신 후 반복
 * 4. 최소 길이 출력
 * 
 * [입력] 
 * 인형 개수 N, 구할 인형 집합의 라이언 인형 개수 K
 * 인형 정보
 * 
 * [출력] 
 * K개의 라이언 인형이 포함된 가장 작은 연속된 인형 집합 크기
 * 
 * @author phsaem
 * @since 2023. 3. 14
 * @see https://www.acmicpc.net/problem/15565
 * @performance 
 * @category 
 */
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K, min;
	static List<Integer> ryans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int num;
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num == 1) 
				ryans.add(i);
		}
		
		if(ryans.size() < K){
			System.out.println(-1);
		}else {
			min = Integer.MAX_VALUE;
			for(int start = 0, end = K-1, size = ryans.size(); end < size; start++, end++) {
				min = Integer.min(min, ryans.get(end) - ryans.get(start) + 1);
			}
			System.out.println(min);
		}
	}

}