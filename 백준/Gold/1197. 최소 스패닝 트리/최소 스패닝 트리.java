import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 최소 신장 트리, 크루스칼, 프림
 * 
 * [풀이과정] 
 * 그래프 입력을 받고 크루스칼을 이용해 최소 가중치를 구한다.
 * 
 * [입력] 
 * 정점 개수 V, 간선 개수 E
 * E개의 간선 정보
 * 
 * [출력] 
 * 최소 가중치
 * 
 * @since 2023. 3. 4
 * @see https://www.acmicpc.net/problem/1197
 * @performance 
 * @category #최소신장트리
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int V, E;
	static int set[];
	static List<Edge> edges;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		set = new int[V+1];
		edges = new ArrayList<>();
		makeSet();
		
		int from, to, weight;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(from, to, weight));
		}
		
		Collections.sort(edges);
		
		int connectedVertex = 1, total = 0;
		for(Edge edge : edges) {
			if(unionSet(edge.from, edge.to) == true) {
				total += edge.weigth;
				if(++connectedVertex == V) break;
			}
		}
		
		System.out.println(total);
	}
	
	static void makeSet() {
		for(int i = 1; i <= V; i++) {
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
		
		if(setA == setB) return false;
		else {
			set[setA] = setB;
			return true;
		}
	}

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weigth;
		
		public Edge(int from, int to, int weigth) {
			this.from = from;
			this.to = to;
			this.weigth = weigth;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weigth, o.weigth);
		}
	}
}