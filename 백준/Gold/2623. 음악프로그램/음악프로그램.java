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
 * 정석적인 위상정렬
 * 
 * [입력] 
 * 가수의 수 N, 보조 PD의 수 M
 * M개의 줄에 걸친 부분 순서(가수의 수, 순서 정보)
 * 
 * [출력] 
 * 가수들의 출연 순서(불가능할 경우 0, 답이 여럿일 경우 아무거나)
 * 
 * @author phsaem
 * @since 2023. 3. 23
 * @see https://www.acmicpc.net/problem/2623
 * @performance 
 * @category #위상정렬
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, C;
	static Singer[] singers;
	static Queue<Singer> queue = new ArrayDeque<>();
	static List<Integer> order = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		singers = new Singer[N+1];
		for(int i = 1; i <= N; i++) {
			singers[i] = new Singer(i);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			
			int prev, cur;
			prev = Integer.parseInt(st.nextToken());
			for(int c = 1; c < C; c++) {
				cur = Integer.parseInt(st.nextToken());
				singers[prev].next.add(cur);
				singers[cur].degree++;
				prev = cur;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(singers[i].degree == 0)
				queue.offer(singers[i]);
		}
		
		Singer cur;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			order.add(cur.num);
			
			for(int n : cur.next) {
				if(--singers[n].degree == 0)
					queue.offer(singers[n]);
			}
		}
		
		if(order.size() != N)
			System.out.println("0");
		else {
			for(int n : order)
				System.out.println(n);
		}
	}
	
	static class Singer{
		int num;
		int degree;
		List<Integer> next;
		
		Singer(int num){
			this.num = num;
			degree = 0;
			next = new ArrayList<>();
		}
	}

}