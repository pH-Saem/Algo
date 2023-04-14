import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, min;
	static char[][] map;
	static boolean[] filledRow, filledCol;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		filledRow = new boolean[N];
		filledCol = new boolean[M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 'X') {
					filledRow[r] = true;
					filledCol[c] = true;
				}
			}
		}
		
		int count = 0;
		for(int r = 0; r < N; r++) {
			if(!filledRow[r]) count++;
		}
		min = count;
		
		count = 0;
		for(int c = 0; c < M; c++) {
			if(!filledCol[c]) count++;
		}
		min = Integer.max(min, count);
		
		System.out.println(min);
	}
}