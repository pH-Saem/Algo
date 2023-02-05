import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int deltas[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static char board[][];
	static Queue<MarbleInfo> q = new LinkedList<>();
	static MarbleInfo cur, afterTilt;
	static Marble red = new Marble(), blue = new Marble();
	
	static class MarbleInfo{
		Marble red;
		Marble blue;
		int count;
		
		public MarbleInfo() {
			red = new Marble();
			blue = new Marble();
		}
		
		public void copy(MarbleInfo m) {
			setRed(m.red);
			setBlue(m.blue);
			this.count = m.count;
		}
		
		public void setRed(Marble p) {
			red.setMarble(p);
		}
		
		public void setBlue(Marble p) {
			blue.setMarble(p);
		}
		
		public boolean isMarbleMoved(MarbleInfo m) {
			return red.isDiff(m.red) || blue.isDiff(m.blue);
		}
	}
	
	static class Marble{
		int r;
		int c;
		boolean isIn;
		
		public Marble() {}
		
		public Marble(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public void setMarble(Marble p){
			this.r = p.r;
			this.c = p.c;
            isIn = false;
		}
		
		public boolean isDiff(Marble p) {
			return r != p.r || c != p.c;
		}
	}
	
	public static void tilt(int d) {
		
		afterTilt.copy(cur);
		afterTilt.count += 1;
		
		moveMarbles(d);
		moveMarbles(d);

	}
	
	public static void moveMarbles(int d) {
		moveMarble(afterTilt.red, afterTilt.blue, d);
		moveMarble(afterTilt.blue, afterTilt.red, d);
	}
	
	public static void moveMarble(Marble mv, Marble st, int d) {
		int dr = deltas[d][1], dc = deltas[d][0];
		

		while(mv.isDiff(st) && board[mv.r][mv.c] != '#') {
			if(board[mv.r][mv.c] == 'O') {
				mv.isIn = true;
				mv.r = 0;
				mv.c = 0;
				break;
			}
			mv.r += dr; mv.c += dc;
		}
		
		if(!mv.isIn) {
			mv.r -= dr;
			mv.c -= dc;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		cur = new MarbleInfo();
		afterTilt = new MarbleInfo();
		
		String line;
		char ch;
		for(int r = 0; r < N; r++) {
			line = br.readLine();
			for(int c = 0; c < M; c++) {
				ch = line.charAt(c);
				if(ch == 'R') {
					cur.setRed(new Marble(r, c));
				}else if(ch == 'B') {
					cur.setBlue(new Marble(r, c));
				}else {
					board[r][c] = ch;
				}
			}
		}
		
		q.add(cur);
		outer : while(!q.isEmpty()) {
			cur = q.poll();
			for(int d = 0; d < deltas.length; d++) {
				tilt(d);
				if(afterTilt.isMarbleMoved(cur) && !afterTilt.blue.isIn) {
					if(afterTilt.red.isIn) {
						System.out.println(afterTilt.count);
						break outer;
					}else if(afterTilt.count < 10){
						q.add(afterTilt);
						afterTilt = new MarbleInfo();
					}
				}
			}
		}
		
		if(!(afterTilt.red.isIn && !afterTilt.blue.isIn)) {
			System.out.println(-1);
		}

	}

}
