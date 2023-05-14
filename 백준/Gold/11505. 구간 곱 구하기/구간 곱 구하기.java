import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static final long DIV = 1_000_000_007L;

	static int N, M, K;
	static int size;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		init();
		solution();
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 트리 생성
		size = 1;
		while (size < N) {
			size *= 2;
		}
		tree = new long[size * 2];
		Arrays.fill(tree, 1);

		// 수 입력
		int num;
		for (int i = 1; i <= N; i++) {
			num = Integer.parseInt(br.readLine());
			update(i, num);
		}
	}

	static void solution() throws IOException {
		int a, b, c;
		for(int i = 0, C = M+K; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				update(b, c);
			}else if(a == 2) {
				output.append(getMul(1, size, b, c, 1)).append("\n");
			}else {
				System.out.println("NOPE");
			}
		}
		
		System.out.println(output);
	}

	static void update(int target, int num) {
		int index = size + target - 1;
		long mul;
		
		tree[index] = num;
		while(index > 1) {
			if(index % 2 == 0) {
				mul = (tree[index] * tree[index + 1]) % DIV;
			}else {
				mul = (tree[index-1] * tree[index]) % DIV;
			}
			index = index / 2;
			tree[index] = mul;
		}
	}

	static long getMul(int start, int end, int tStart, int tEnd, int cur) {
		if(end < tStart || tEnd < start) {
			return 1;
		}
		
		if(tStart <= start && end <= tEnd) {
			return tree[cur];
		}
		else {
			long result = 1;
			int mid = (start + end) / 2;
			
			result *= getMul(start, mid, tStart, tEnd, cur * 2);
			result *= getMul(mid + 1, end, tStart, tEnd, cur * 2 + 1);
			
			result %= DIV;
			
			return result;
		}
	}
}