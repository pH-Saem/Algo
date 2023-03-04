import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [키워드] 완전탐색, BFS, 그래프탐색
 * 
 * [풀이과정] 1. 입력 -> 무향 그래프 인접 리스트 2. 모든 정점에 대해 BFS 돌면서 Depth가 5가 되는 정점 있는지 확인
 * (있으면 종료. 없으면 다 돌아본다.) 3. 결과 출력
 * 
 * [입력] 사람 수 N(정점), 친구 관계 수 M(간선) 입력 관계 정보 입력
 * 
 * [출력] 존재하는 경우 1 없는 경우 0
 * 
 * @since 2023.
 * @see https://www.acmicpc.net/problem/13023
 * @performance
 * @category #
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, isExist;
	static List<ArrayList<Integer>> edges;
	static boolean isFound, isVisited[];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edges = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < N; i++) {
			edges.add(new ArrayList<Integer>());
		}

		int v1, v2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			v1 = Integer.parseInt(st.nextToken());
			v2 = Integer.parseInt(st.nextToken());
			edges.get(v1).add(v2);
			edges.get(v2).add(v1);
		}

		for (int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			
			dfs(i, 1);
			
			if (isFound == true)
				break;
		}

		if (isFound)
			System.out.println(1);
		else
			System.out.println(0);
	}

	public static void dfs(int v, int cnt) {
		if(isFound == true) return;
		
		isVisited[v] = true;
		for (int to : edges.get(v)) {
			if (isVisited[to] == false) {
				if(cnt + 1 == 5) {
					isFound = true;
					return;
				}
				
				dfs(to, cnt + 1);
				isVisited[to] = false;
			}
		}
	}
	
	public static void dfs(int v) {
		Position from;
		boolean isVisited[] = new boolean[N];
		Deque<Position> stack = new ArrayDeque<>();

		stack.push(new Position(v, 1));
		
		outer : while (!stack.isEmpty()) {
			from = stack.pop();
			isVisited[from.v] = true;
			
			for (int to : edges.get(from.v)) {
				if (isVisited[to] == false) {
					if(from.cnt + 1 == 5) {
						isFound = true;
						break outer;
					}
					
					stack.push(new Position(to, from.cnt + 1));
				}
			}
		}
	}

	static class Position {
		int v;
		int cnt;

		Position(int v, int cnt) {
			this.v = v;
			this.cnt = cnt;
		}
	}
}