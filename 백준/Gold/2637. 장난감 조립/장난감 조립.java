import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 위상정렬
 * 
 * [풀이과정] 
 * 1. 
 * 
 * [입력] 
 * 자연수 N (1~N-1 : 기본, 중간 부품, N : 완제품)
 * 부품들 간의 관계 개수 M
 * M개의 부품들 간의 관계 X, Y, K -> X를 만드는 데 Y가 K개 필요하다
 * 
 * [출력] 
 * 완제품을 만드는 데 필요한 기본 부품의 수(번호가 작은 것 부터)
 * 
 * @author phsaem
 * @since 2023. 3. 26
 * @see https://www.acmicpc.net/problem/2637
 * @performance 
 * @category #위상정렬
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, X, Y, K;
	static Part[] parts;
	static List<Integer> basicParts = new ArrayList<>();
	static Queue<Part> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parts = new Part[N+1];
		for(int i = 1; i <= N; i++) {
			parts[i] = new Part(i);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			parts[Y].next.add(X);
			parts[X].degree++;
			parts[X].parts[Y] += K;	// X 만드는 데 Y가 K개 필요하다 표시
		}
		
		// 기본 부품들
		for(int i = 1; i <= N; i++) {
			if(parts[i].degree == 0) {
				queue.offer(parts[i]);
				basicParts.add(i);
			}
		}
		
		Part x, y;
		while(!queue.isEmpty()) {
			x = queue.poll();
			
			for(int n : x.next) {
				y = parts[n];
				
				// 기본 부품 개수 갱신
				int count = y.parts[x.num];				// y를 만드는데 x가 필요한 개수
				for(int b : basicParts) {
					y.parts[b] += count * x.parts[b];	// x를 만드는데 필요한 기본 부품 개수 * x가 필요한 개수만큼 더해준다.
				}
				
				// 차수 갱신
				if(--y.degree == 0)
					queue.offer(y);
			}
		}
		
		for(int b : basicParts) {
			output.append(b).append(" ").append(parts[N].parts[b]).append("\n");
		}
		
		System.out.println(output);
	}

	static class Part{
		int num;				// 부품 번호
		int degree;				// 진입 차수
		List<Integer> next;		// 이 부품이 필요한 부품들
		int[] parts;			// 사용된 부품의 수 저장할 배열
		
		Part(int num){
			this.num = num;
			degree = 0;
			next = new ArrayList<>();
			parts = new int[N+1];
		}
	}
}