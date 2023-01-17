import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private int solution() throws IOException {
		int N, x, y, ans = -1;
		int[][] board = new int[22][22];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 22; i++) {
			board[i][i] = 0;
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			// 돌 입력(홀 : 검은돌(1) 짝 : 흰돌(2))
			if(i % 2 == 0) {
				board[x][y] = 2;
			}else {
				board[x][y] = 1;
			}
			
			// 승패가 갈리는지 확인
			if(Main.check(board, x, y)) {
				ans = i;
				break;
			}
		}
		
		return ans;
	}
	
	//주어진 x, y 좌표의 모든 방향으로 연속된 돌 개수를 확인
	// 5개 연속된 돌 있으면 true 그 외의 모든 경우 false
	public static boolean check(int[][] board, int x, int y) {
		int count = 1, step, color = board[x][y];
		int[] xd = {1, -1, 0, 0, 1, -1, -1, 1};
		int[] yd = {0, 0, 1, -1, 1, -1, 1, -1};
		boolean end = false;
		
		for(int i = 0; i < 4; i++) {
			count = 1;
			step = 1;
			while(board[x+step*xd[i*2]][y+step*yd[i*2]] == color) {
				count++;
				step++;
			}
			step = 1;
			while(board[x+step*xd[i*2+1]][y+step*yd[i*2+1]] == color) {
				count++;
				step++;
			}
			if(count == 5) {
				end = true;
			}
		}
		
		return end;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(new Main().solution());
	}

}
