import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int T, N, M;
	static int[] set;
	static Queue<Edge> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			init();
			solution();
		}
		System.out.println(output);
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		queue.clear();
		
		int a, b;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			queue.offer(new Edge(a, b));
		}
	}
	
	static void solution() {
		int connected = 1;
		int count = 0;
		
		makeSet();
		
		Edge e;
		outer : while(!queue.isEmpty()) {
			e = queue.poll();
			
			if(unionSet(e.V1, e.V2)) {
				count++;
				if(++connected == N)
					break outer;
			}
		}
		
		output.append(count).append("\n");
	}
	
	static void makeSet() {
		set = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			set[i] = i;
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
	
	static class Edge{
		int V1;
		int V2;
		
		public Edge(int v1, int v2) {
			V1 = v1;
			V2 = v2;
		}
	}

}