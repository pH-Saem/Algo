import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int deltas[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static int R, C, board[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			line = br.readLine();
			for(int c = 0; c < C; c++) {
				board[r][c] = line.charAt(c) - 'A';
			}
		}
		
		
		System.out.println(move(0, 0, 1 << board[0][0], 1));
	}

	// check에 비트로 지나온 알파벳들을 체크한다.
	public static int move(int r, int c, int check, int count) {
		int nr, nc, max = 0;
		for(int d = 0, size = deltas.length; d < size; d++) {
			nr = r + deltas[d][0];
			nc = c + deltas[d][1];
			if(isIn(nr, nc) && isNotUsed(nr, nc, check)) {
				max = Integer.max(max, move(nr, nc, check | (1 << board[nr][nc]), count + 1));
			}
		}
		
		return Integer.max(max, count);
	}
	
	public static boolean isNotUsed(int r, int c, int check) {
		int num = board[r][c];
		if((check & (1 << num)) == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}