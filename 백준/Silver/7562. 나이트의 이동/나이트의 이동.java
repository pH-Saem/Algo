import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Position {
		int r;
		int c;
		int count;

		Position(int r, int c, int count) {
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}

	static int deltas[][] = { { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 } };
	static int T, l, nr, nc, visited[][];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<Position> q;
	static Position cur, dest;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		q = new LinkedList<>();

		for (int t = 0; t < T; t++) {
			l = Integer.parseInt(br.readLine());
			visited = new int[l][l];
			q.clear();

			st = new StringTokenizer(br.readLine());
			cur = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			st = new StringTokenizer(br.readLine());
			dest = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			q.add(cur);
			if(cur.r != dest.r || cur.c != dest.c) {
				outer : while (!q.isEmpty()) {
					cur = q.poll();
					for (int d = 0; d < deltas.length; d++) {
						nr = cur.r + deltas[d][1];
						nc = cur.c + deltas[d][0];
						
						if(nr == dest.r && nc == dest.c) {
							dest.count = cur.count + 1;
							break outer;
						}
						
						if (isIn(nr, nc) && visited[nr][nc] == 0) {
							q.add(new Position(nr, nc, cur.count+1));
							visited[nr][nc] = 1;
						}
					}
				}
			}
			System.out.println(dest.count);
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < l && c >= 0 && c < l;
	}

}
