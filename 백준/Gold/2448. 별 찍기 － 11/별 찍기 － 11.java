import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int width = 5;
		int[][] bp;
		StringBuilder ans = new StringBuilder();
		
		for(int i = N; i != 3; i >>= 1) {
			width = width*2 + 1;
		}
		bp = new int[N][width];
		
		checkStarOnBP(bp, 0, 0, N, width);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < width; j++) {
				if(bp[i][j] == 1) {
					ans.append("*");
				}else {
					ans.append(" ");
				}
			}
			ans.append("\n");
		}
		
		System.out.println(ans);
	}
	
	public void checkStarOnBP(int[][] bp, int x, int y, int N, int width) {
		if(N != 3) {
			N >>= 1;
			width >>= 1;
			checkStarOnBP(bp, x + width - (width >> 1), y, N, width);
			checkStarOnBP(bp, x + width + 1, y + N, N, width);
			checkStarOnBP(bp, x, y + N, N, width);
		}else {
			bp[y][x+2] = 1;
			bp[y+1][x+1] = 1;
			bp[y+1][x+3] = 1;
			for(int i = 0; i < 5; i++) {
				bp[y+2][x+i] = 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
