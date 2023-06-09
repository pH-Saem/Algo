import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static int[] nums;
	static Set<String> result = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		init();
		solution();
	}

	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
	}

	static void solution(){
		makePermutation(0, new int[M], new boolean[N]);

		output.setLength(0);
		for(String s : result){
			output.append(s);
		}
		System.out.println(output);
	}

	static void makePermutation(int nthChoice, int[] choosed, boolean[] isUsed){
		if(nthChoice == M){
			output.setLength(0);
			for(int i = 0; i < M; i++){
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			result.add(output.toString());
			return;
		}

		for(int i = 0; i < N; i++){
			if(isUsed[i]) continue;
			isUsed[i] = true;
			choosed[nthChoice] = nums[i];
			makePermutation(nthChoice + 1, choosed, isUsed);
			isUsed[i] = false;
		}
	}
}