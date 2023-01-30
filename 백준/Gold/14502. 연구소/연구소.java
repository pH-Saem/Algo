import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, max, temp, lab[][], labCopy[][];
	static List<Position> virus = new ArrayList<>(), empty = new ArrayList<>();

	static class Position {
		int r;
		int c;

		Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
        labCopy = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
				if(lab[r][c] == 2) {
					virus.add(new Position(r, c));
				}else if(lab[r][c] == 0) {
					empty.add(new Position(r, c));
				}
			}
		}
		
		Position pi, pj, pk;
		for (int i = 0; i < empty.size(); i++) {
			pi = empty.get(i);
			for (int j = i + 1; j < empty.size(); j++) {
				pj = empty.get(j);
				for (int k = j + 1; k < empty.size(); k++) {
					pk = empty.get(k);
					
					for (int r = 0; r < N; r++) {
						for (int c = 0; c < M; c++) {
							labCopy[r][c] = lab[r][c];
						}
					}
					
					labCopy[pi.r][pi.c] = 1;
					labCopy[pj.r][pj.c] = 1;
					labCopy[pk.r][pk.c] = 1;
					
					for(Position p : virus) {
						virusDiffuse(p.r, p.c);
					}
					
					max = Integer.max(max, getSafeAreaCount());
				}
			}
		}
		
		System.out.println(max);
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	public static void virusDiffuse(int r, int c) {
		int deltas[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int nr, nc;
		labCopy[r][c] = 2;
		for(int d = 0; d < deltas.length; d++) {
			nr = r + deltas[d][1];
			nc = c + deltas[d][0];
			if(isIn(nr, nc) && labCopy[nr][nc] == 0) {
				virusDiffuse(nr, nc);
			}
		}
	}

	public static int getSafeAreaCount() {
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(labCopy[r][c] == 0) {
					count++;
				}
			}
		}
		return count;
	}

}
