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
 * 1. 위상정렬을 한다.
 * 2. 위상정렬을 할 때 각 건물마다 해당 건물의 완성까지 걸리는 누적시간을 저장
 * (이전 건물에서 다음 건물에 대한 차수를 줄여줄 때 시간을 갱신하자!)
 *
 * [입력]
 * 테스트케이스 개수 T
 * 건물의 개수 N, 건설순서 규칙의 총 개수 K
 * 건물당 건설에 걸리는 시간
 * K 줄에 걸친 건설순서 X Y (X -> Y)
 * 건설해야 할 건물의 번호 W
 * 
 * [출력] 
 * 건물 W를 건설하는데 드는 최소 시간
 * 
 * @author phsaem
 * @since 2023. 3. 20
 * @see https://www.acmicpc.net/problem/1005
 * @performance 
 * @category #위상정렬
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int T, N, K, X, Y, W;
	static Building[] buildings;
	static boolean isFinished = false;
	static Queue<Building> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			queue.clear();
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			buildings = new Building[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				buildings[i] = new Building(i, Integer.parseInt(st.nextToken()), 0);
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());
				buildings[X].next.add(Y);
				buildings[Y].degree++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= N; i++) {
				if(buildings[i].degree == 0) queue.offer(buildings[i]);
			}
			
			Building cur, next;
			while(!queue.isEmpty()) {
				cur = queue.poll();
				cur.time += cur.prevTime;
				if(cur.index == W) break;
				
				// 다음 건물들 prevTime 갱신 + 진입차수--
				for(int nextIndex : cur.next) {
					next = buildings[nextIndex];
					next.prevTime = Integer.max(next.prevTime, cur.time);
					if(--next.degree == 0)
						queue.offer(next);
				}
			}
			
			output.append(buildings[W].time).append("\n");
		}
		
		System.out.println(output);
	}
	
	static class Building{
		int index;
		int time;		// 이 건물을 짓기 위해 필요한 시간
		int prevTime;	// 선행 건물을 짓기 위해 필요한 시간
		int degree;		// 진입차수(이 건물을 짓기 위해 지어야 하는 건물 개수)
		List<Integer> next;
		
		public Building(int index, int time, int degree) {
			this.index = index;
			this.time = time;
			this.degree = degree;
			next = new ArrayList<>();
		}
	}

}