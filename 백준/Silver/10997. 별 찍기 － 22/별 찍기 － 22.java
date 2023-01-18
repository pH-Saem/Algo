import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int bp[][];
	static int deltas[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int d = 0;
	static int width, height, N;
	
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		width = 1 + 4*(N-1);
		height = N==1? 1 : 4*N-1;
		bp = new int[height][width];
		StringBuilder ans = new StringBuilder();
		
		move(width-1, 0);
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(bp[i][j] == 0) {
					ans.append(" ");
				}else if(bp[i][j] == 1) {
					ans.append("*");
				}
				if(i == 1) {
					break;
				}
			}
			ans.append("\n");
		}
		
		System.out.println(ans);
	}
	
	public static void move(int x, int y) {
		int dx = deltas[d][0], dy = deltas[d][1];
		bp[y][x] = 1;
		
		
		if(!isIn(x + dx, y + dy)) {
			d++;
		}else if(isIn(x + 2*dx, y + 2*dy)) {
			if(bp[y+2*dy][x+2*dx] == 1) {
				d++;
			}
		}
		d = d%4;
		if(N!=1 && (x != width/2 || y != height/2 + 1)) {
			move(x + deltas[d][0], y + deltas[d][1]);
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && x < width && y >= 0 && y < height;
	}
	
	public static void main(String[] args) throws IOException {
		solution();
	}

}
