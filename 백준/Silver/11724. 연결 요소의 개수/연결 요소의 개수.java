import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, count, V[][], visited[];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		V = new int[N+1][N+1];
		visited = new int[N+1];
		int u, v;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			V[u][v] = 1;
			V[v][u] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void dfs(int v) {
		visited[v] = 1;
		for(int i = 1; i <= N; i++) {
			if(V[v][i] == 1 && visited[i] == 0) {
				dfs(i);
			}
		}
	}
	
}
