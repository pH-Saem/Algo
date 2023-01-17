import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int size = 1+4*(N-1);
		int bp[][] = new int[size][size];
		StringBuilder ans = new StringBuilder();
		
		square(0, 0, size, bp);
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
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
	
	public void square(int x, int y, int size, int[][] bp) {
		if(size != 1) {
			for(int i = 0; i < size; i++) {
				bp[y][x + i] = 1;
				bp[y+size-1][x + i] = 1;
				bp[y + i][x] = 1;
				bp[y + i][x+size-1] = 1;
			}
			square(x+2, y+2, size-4, bp);
		}else {
			bp[y][x] = 1;
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
