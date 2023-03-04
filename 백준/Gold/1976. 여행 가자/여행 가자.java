import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 유니온 파인드
 * 
 * [풀이과정] 
 * 도시 정보를 입력받아 연결된 도시는 같은 집합으로 처리한다.
 * 여행 계획에 포함된 도시들이 모두 같은 집합이면 가능. 아니면 불가능
 * 
 * [입력] 
 * 도시 수 N
 * 여행 계획에 속한 도시 수 M
 * 도시 정보 NxN
 * 
 * [출력] 
 * 가능여부 YES or NO
 * 
 * @since 2023. 3. 4
 * @see https://www.acmicpc.net/problem/1976
 * @performance 
 * @category #유니온파인드
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static int set[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		set = new int[N+1];
		makeSet();
		
		for(int from = 1; from <= N; from++) {
			st = new StringTokenizer(br.readLine());
			for(int to = 1; to <= N; to++) {
				if(st.nextToken().equals("1")) {
					unionSet(from, to);
				}
			}
		}
		
		int cityNum, citySet = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			cityNum = Integer.parseInt(st.nextToken());
			if(citySet == 0)
				citySet = findSet(cityNum);
			else if(citySet != findSet(cityNum)) {
				citySet = -1;
				break;
			}
		}
		
		if(citySet == -1)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	
	static void makeSet() {
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
		
		if(setA == setB) return false;
		else {
			set[setA] = setB;
			return true;
		}
	}
}