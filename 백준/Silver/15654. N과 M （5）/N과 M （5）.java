import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, nums[];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		makePermutation(0, new int[M], new boolean[N]);
		
		System.out.println(output);
	}
	
	public static void makePermutation(int nthChoice, int[] choosed, boolean[] isUsed) {
		if(nthChoice == M) {
			for(int i = 0; i < M; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isUsed[i] == true) continue;
			
			isUsed[i] = true;
			choosed[nthChoice] = nums[i];
			makePermutation(nthChoice + 1, choosed, isUsed);
			isUsed[i] = false;
		}
	}

}