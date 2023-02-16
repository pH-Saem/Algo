import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int room[][][], curRoom = 0, newRoom;
	static int R, C, T, ar, ac, sum;
	static int deltas[][][] = {{{0, -1, 0, 1}, {1, 0, -1, 0}}, {{0, 1, 0, -1}, {1, 0, -1, 0}}}; // 0 : Up 1 : down
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[2][R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				room[curRoom][r][c] = Integer.parseInt(st.nextToken());
				if(room[curRoom][r][c] == -1) {
					ar = r;
					ac = c;
				}
			}
		}
		
		
		for(int t = 0; t < T; t++) {
			dustsDiffuse();
			wind(true);
			wind(false);
//			//방 정보 출력
//			System.out.println();
//			for(int r = 0; r < R; r++) {
//				for(int c = 0; c < C; c++) {
//					System.out.printf("%d ", room[newRoom][r][c]);
//				}
//				System.out.println();
//			}
			
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				sum += room[curRoom][r][c];
			}
		}
		sum += 2;
		System.out.println(sum);
	}
	
	public static void dustsDiffuse() {	
		newRoom = curRoom == 0 ? 1 : 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				room[newRoom][r][c] = 0;
			}
		}
		room[newRoom][ar][ac] = -1;
		room[newRoom][ar-1][ac] = -1;
		
		int dust;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				dust = room[curRoom][r][c];
				if(dust > 0) {
					// 사방탐색
					dustDiffuse(r, c, dust);
				}
			}
		}
		
		curRoom = curRoom == 0 ? 1 : 0;
	}
	
	public static void dustDiffuse(int r, int c, int dust) {
		int dCount, dr, dc;
		dCount = 0;
		for(int i = 0; i < 4; i++) {
			dr = r + deltas[0][0][i];
			dc = c + deltas[0][1][i];
			if(isDiffuseable(dr, dc)) {
				dCount++;
				room[newRoom][dr][dc] += dust / 5;
			}
		}
		room[newRoom][r][c] += dust - dCount*(dust/5);
	}
	
	public static void wind(boolean isUp) {
		int prev, cur, dr, dc, delta;
		
		dr = ar; dc = ac+1;
		if(isUp) {
			delta = 0;
			dr--;
		}else {
			delta = 1;
		}
		
		prev = room[curRoom][dr][dc];
		room[curRoom][dr][dc] = 0;
		for(int d = 0; d < 4; d++) {
			while(true) {
				if(!isDiffuseable(dr + deltas[delta][0][d], dc + deltas[delta][1][d]))
					break;
				dr += deltas[delta][0][d];
				dc += deltas[delta][1][d];
				cur = room[curRoom][dr][dc];
				room[curRoom][dr][dc] = prev;
				prev = cur;
			}
		}
	}
	
	public static boolean isDiffuseable(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C && room[newRoom][r][c] != -1;
	}

}