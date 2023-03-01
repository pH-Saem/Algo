import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 1. 완전탐색 -> 도시가 최대 10개 밖에 없다. 
 * 최대 10개의 도시 순열로 순서 생성 시작 도시로 돌아갈 수 있는 경우 순회
 * 비용 계산 후 최소 비용 출력 
 *
 * [풀이과정]
 *  1. N이 최대 10개이므로 10x10 인접행렬 만들고 입력 받아 그래프 표현 
 *  2. N! 만큼 경우의 수 순열로 생성한다.
 * 	3. -> 생성하는 과정에서 연결 여부 확인 후 백트레킹
 * 	4. 순열 완성 시 시작 도시로 돌아갈 수 있는 지 확인 
 * 	5. 가능한 경우에만 순회 비용 계산 후 최소 비용 갱신 
 * 	6. 모든 순열에 대해 3-5 반복 
 * 	7. 최소 비용 출력
 * 
 * [입력] 도시 N개의 가중치 크래프 정보
 * 
 * [출력] 순회 최소 비용
 * 
 * @since 2023. 
 * @see 
 * @performance 
 * @category
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, minCost = Integer.MAX_VALUE, graph[][] = new int[10][10];
	static int travelPlan[];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 도시 개수 N 입력
		N = Integer.parseInt(br.readLine());
		
		travelPlan = new int[N];
		visited = new boolean[N];
		
		// 도시 연결 정보 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 순열 생성
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			travelPlan[0] = i;			// 시작 도시 선택 후
			makePermutation(1, 0);		// 나머지 도시들 선택 및 최소 비용 계산
			visited[i] = false;
		}
		
		System.out.println(minCost);
	}
	
	static void makePermutation(int nthChoice, int cost) {
		// 모든 순회 순서를 선택한 경우
		if(nthChoice == N) {
			// 마지막 도시에서 시작 도시로 갈 수 있는 경우
			int start = travelPlan[0], end = travelPlan[N-1];
			if(graph[end][start] != 0) {
				cost = cost + graph[end][start];
				minCost = Integer.min(minCost, cost);
			}
			return;
		}

		int prevCity = travelPlan[nthChoice - 1];
		for(int i = 0; i < N; i++) {
			// 아직 방문하지 않은 도시이면서 이전 도시에서 갈 수 있는 경로가 있는 경우
			if(visited[i] == false && graph[prevCity][i] != 0) {
				visited[i] = true;
				travelPlan[nthChoice] = i;
				makePermutation(nthChoice + 1, cost + graph[prevCity][i]);
				visited[i] = false;
			}
		}
	}
}