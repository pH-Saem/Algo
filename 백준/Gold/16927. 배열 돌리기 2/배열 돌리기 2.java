import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, R;
	static int map[][], dr[] = {0, 1, 0, -1}, dc[] = {1, 0, -1, 0};
	static boolean isVisited[][];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		rotate(0, 0, N, M);
		rotateArray(0, 0, N, M);
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				output.append(map[r][c]).append(" ");
			}
			output.setLength(output.length() - 1);
			output.append("\n");
		}
		
		System.out.println(output);
	}
	
	public static void rotate(int r, int c, int N, int M) {
		int boxSize = N*M - (N-2)*(M-2);
		int rotateCount = R % boxSize;
		int nr, nc;
		
		// rotateCount만큼 회전시키기
		List<Integer> list = new ArrayList<>();
		nr = r; nc = c - 1;
		for(int d = 0; d < 4; d++) {
			while(isValid(nr + dr[d], nc + dc[d])) {
				nr += dr[d];
				nc += dc[d];
				list.add(map[nr][nc]);
			}
		}
		list.remove(list.size() - 1);
//		list.addAll(list.subList(0, rotateCount));
		
		int index = rotateCount;
		nr = r; nc = c - 1;
		for(int d = 0; d < 4; d++) {
			while(isValid(nr + dr[d], nc + dc[d])) {
				nr += dr[d];
				nc += dc[d];
				map[nr][nc] = list.get(index++);
				isVisited[nr][nc] = true;
				
				if(index == list.size())
					index = 0;
			}
		}
		
		// 더 작은 부분 회전
		if(N - 2 != 0 && M - 2 != 0) {
			rotate(r + 1, c + 1, N - 2, M - 2);
		}
	}
	
	public static void rotateArray(int r, int c, int N, int M) {
		int boxSize = N*M - (N-2)*(M-2);
		int rotateCount = R % boxSize;
		int nr, nc, index;
		
		// rotateCount만큼 회전시키기
		int list[] = new int[boxSize+1];
		nr = r; nc = c - 1; index = 0;
		for(int d = 0; d < 4; d++) {
			while(isValid(nr + dr[d], nc + dc[d])) {
				nr += dr[d];
				nc += dc[d];
				list[index++] = map[nr][nc];
			}
		}
		
		index = rotateCount;
		nr = r; nc = c - 1;
		for(int d = 0; d < 4; d++) {
			while(isValid(nr + dr[d], nc + dc[d])) {
				nr += dr[d];
				nc += dc[d];
				map[nr][nc] = list[index++];
				isVisited[nr][nc] = true;
				
				if(index == boxSize)
					index = 0;
			}
		}
		
		// 더 작은 부분 회전
		if(N - 2 != 0 && M - 2 != 0) {
			rotate(r + 1, c + 1, N - 2, M - 2);
		}
	}
	
	public static boolean isValid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && !isVisited[r][c];
	}
}