import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N, Q, size;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		input();
		solution();
		System.out.println(output);
	}
	
	static void input() throws IOException {
		int num;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		size = 1;
		while(size < N) size <<= 1;
		
		tree = new long[size<<1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			num = Integer.parseInt(st.nextToken());
			update(i, num);
		}
	}
	
	static void solution() throws IOException {
		int x, y, a, b;
		long result;
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			result = sum(Integer.min(x, y), Integer.max(x, y));
			update(a, b);
			
			output.append(result).append("\n");
		}
	}
	
	static void update(int index, int num) {
		int treeIndex = size + index - 1;
		long diff = num - tree[treeIndex];
		
		while(treeIndex > 0) {
			tree[treeIndex] += diff;
			treeIndex >>= 1;
		}
	}
	
	static long sum(int start, int end) {
		int left = size + start - 1;
		int right = size + end - 1;
		long result = 0;
		
		while(left < right) {
			if(left % 2 == 1) {
				result += tree[left];
				left = (left>>1) + 1;
			}else {
				left = left>>1;
			}
			
			if(right % 2 == 0) {
				result += tree[right];
				right = (right>>1) - 1;
			}else {
				right = right>>1;
			}
		}
		
		if(left == right)
			result += tree[left];
		
		return result;
	}
}