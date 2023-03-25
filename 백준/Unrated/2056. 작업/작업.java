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
 * 1. 작업별로 선행 작업을 모두 마치는데 필요한 시간과 소요 시간 저장
 * 2. 진입차수가 0이 되면 선행 작업 시간 + 소요 시간으로 해당 작업을 마치는데 필요한 시간 계산
 * 3. 계산한 시간으로 최대 시간 갱신 및 다음 작업의 선행 작업 시간 갱신
 *
 * [입력]
 * 수행해야 할 작업 개수 N
 * N개의 작업에 대한 정보 (해당 작업에 걸리는 시간, 선행 관계에 있는 작업들 개수, 번호)
 * 
 * [출력] 
 * 모든 작업을 완료하기 위한 최소 시간
 *
 * @author phsaem
 * @since 2023. 3. 
 * @see https://www.acmicpc.net/problem/2056
 * @performance 
 * @category #
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static Work[] works;
	static Queue<Work> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		works = new Work[N+1];
		for(int i = 1; i <= N; i++) {
			works[i] = new Work();
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			// i번 작업에 걸리는 시간
			works[i].time = Integer.parseInt(st.nextToken());
			
			// 선행 작업들의 개수
			M = Integer.parseInt(st.nextToken());
			works[i].degree = M;
			if(M == 0) queue.offer(works[i]);
			
			// 선행 작업 정보 입력 -> 해당 작업들의 next에 i를 넣어준다
			for(int j = 0; j < M; j++) {
				works[Integer.parseInt(st.nextToken())].next.add(i);
			}
		}
		
		Work cur;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			cur.time += cur.prevTime;
			for(int n : cur.next) {
				if(works[n].prevTime < cur.time)
					works[n].prevTime = cur.time;
				if(--works[n].degree == 0)
					queue.offer(works[n]);
			}
		}
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Integer.max(result, works[i].time);
		}
		
		System.out.println(result);
	}

	static class Work{
		int time;
		int prevTime;
		int degree;
		List<Integer> next;
		
		Work(){
			prevTime = 0;
			degree = 0;
			next = new ArrayList<>();
		}
	}
}