import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, mstWeight;
	static int[] set;
	static int[][] question;
	static List<Edge>[] graph;
	static Queue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		input();
		kruskal();
		buildTeam();
		System.out.println(output);
	}
	
	static void input() throws IOException {
		int A, B, C, Q;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(A, B, C));
		}
		
		Q = Integer.parseInt(br.readLine());
		
		question = new int[Q][2];
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			question[i][0] = A;
			question[i][1] = B;
		}
	}
	
	static void kruskal() {
		int edgeCount = 1;
		
		// makeSet
		set = new int[N+1];
		graph = new List[N+1];
		for(int i = 1; i <= N; i++) {
			set[i] = i;
			graph[i] = new ArrayList<>();
		}
		
		Edge e;
		while(!pq.isEmpty() && edgeCount < N) {
			e = pq.poll();
			
			if(unionSet(e.from, e.to)) {
				mstWeight += e.weight;
				graph[e.from].add(new Edge(e.from, e.to, e.weight));
				graph[e.to].add(new Edge(e.to, e.from, e.weight)); 
			}
		}
	}
	
	static int findSet(int a) {
		if(a == set[a]) return a;
		else
			return set[a] = findSet(set[a]);
	}
	
	static boolean unionSet(int a, int b) {
		int setA = findSet(a);
		int setB = findSet(b);
		
		if(setA == setB)
			return false;
		else {
			set[setA] = setB;
			return true;
		}
	}
	
	static void buildTeam() {
		Queue<Status> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		int A, B, answer;
		Status cur = null;
		
		for(int[] q : question) {
			// 초기화
			queue.clear();
			for(int i = 0; i <= N; i++) {
				visited[i] = false;
			}
			
			A = q[0];
			B = q[1];

			visited[A] = true;
			queue.offer(new Status(A, 0));
			// 조장 A와 B를 연결하는 간선 중 가중치가 가장 큰 간선을 찾는다.
			while(!queue.isEmpty()) {
				cur = queue.poll();
				
				if(cur.num == B) break;
				
				for(Edge e : graph[cur.num]) {
					if(!visited[e.to]) {
						visited[e.to] = true;
						queue.offer(new Status(e.to, Integer.max(cur.maxWeight, e.weight)));
					}
				}
			}
			answer = mstWeight - cur.maxWeight;
			
			output.append(answer).append("\n");
		}
	}
	
	static class Status{
		int num;			// 학생 번호
		int maxWeight;		// 지나온 간선 중 최대 가중치
		
		public Status(int num, int maxWeight) {
			this.num = num;
			this.maxWeight = maxWeight;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}

}
