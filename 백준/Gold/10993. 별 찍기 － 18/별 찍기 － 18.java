import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int bp[][];
		int width = 1, height = 1, baseX, baseY;
		StringBuilder ans = new StringBuilder();
		
		for(int i = 1; i < N; i++) {
			width = width * 2 + 3;
			height = height * 2 + 1;
		}
		
		bp = new int[height][width];
		
		baseX = 0;
		baseY = N%2 == 0 ? 0 : height - 1;
	
		int dx, dy;
		for(int i = N; i > 0; i--) {
			for(int j = 0; j < width; j++) {
				bp[baseY][baseX + j] = 1;
			}
			if(i % 2 == 0) {
				dy = 1;
			}else {
				dy = -1;
			}
			
			for(int j = 1; j < height; j++) {
				bp[baseY + dy*j][baseX + j] = 1;
				bp[baseY + dy*j][baseX + width - 1 - j] = 1;
				if(i == N) {
					bp[baseY + dy*j][baseX + width - 1 - j] = 2;
				}
			}
			
			baseX = baseX + (width - (width - 3) / 2) / 2;
			width = (width - 3) / 2;
			height = height / 2;
			if(i % 2 == 0) {
				baseY += height;
			}else {
				baseY -= height;
			}
		}
		
		for(int[] row : bp) {
			for(int col : row) {
				if(col == 0) {
					ans.append(" ");
				}else {
					ans.append("*");
				}
				if(col == 2) {
					break;
				}
			}
			ans.append("\n");
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
