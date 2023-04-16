import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, start, end;
	static List<Path>[] graph;
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(findMinDist());
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		graph = new List[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int room1, room2, weight;
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			room1 = Integer.parseInt(st.nextToken());
			room2 = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			graph[room1].add(new Path(room2, weight));
			graph[room2].add(new Path(room1, weight));			
		}
	}
	
	// 두 로봇이 통신하기 위한 최소 이동거리 구하기
	// 1. 두 로봇 중 한 로봇에서 BFS로 최단 경로를 찾는다.
	// 2. 최단 경로에 포함된 경로 중 가장 큰 가중치를 갖는 값을 뺀다.
	static int findMinDist() {
		Queue<Status> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		int weightSum, maxWeight, result = 0;
		Status cur;
		
		visited[start] = true;
		queue.offer(new Status(start, 0, 0));
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
			// 다른 로봇과 만나면 종료
			if(cur.num == end) {
				result = cur.totalWeight - cur.maxWeight;
				break;
			}
			
			// 해당 방과 연결된 아직 가보지 않은 방을 탐색한다
			for(Path p : graph[cur.num]) {
				if(visited[p.num]) continue;
				
				visited[p.num] = true;
				
				weightSum = cur.totalWeight + p.weigth;
				maxWeight = Integer.max(p.weigth, cur.maxWeight);
				
				queue.offer(new Status(p.num, weightSum, maxWeight));
			}
		}
		
		return result;
	}
	
	static class Status{
		int num;			// 현재 방 번호
		int totalWeight;	// 현재까지 가중치 총합
		int maxWeight;		// 현재까지 가장 큰 경로의 가중치 값
		
		public Status(int num, int totalWeight, int maxWeight) {
			this.num = num;
			this.totalWeight = totalWeight;
			this.maxWeight = maxWeight;
		}
	}
	
	static class Path{
		int num;
		int weigth;
		
		public Path(int num, int weigth) {
			this.num = num;
			this.weigth = weigth;
		}
	}
}