import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static int a, b, c, d, e, f;

	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		solution();
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
	}

	static void solution() {
		outer: for(int x = -999; x < 1000; x++) {
			for(int y = -999; y < 1000; y++) {
				if(a*x + b*y == c && d*x + e*y == f) {
					System.out.println(x + " " + y);
					break outer;
				}
			}
		}
	}

}