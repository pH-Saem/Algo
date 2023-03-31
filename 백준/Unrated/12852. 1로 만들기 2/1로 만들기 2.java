import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[] count, prev;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		count = new int[N+1];
		prev = new int[N+1];
		
		Arrays.fill(count, Integer.MAX_VALUE);
		count[1] = 0;
		
		// 1~N-1까지 밑에서부터 올라가본다
		for(int i = 1; i < N; i++) {
			if(count[i+1] > count[i] + 1) {
				count[i+1] = count[i] + 1;
				prev[i+1] = i;
			}
			if(i*2 <= N && count[i*2] > count[i] + 1) {
				count[i*2] = count[i] + 1;
				prev[i*2] = i;
			}
			if(i*3 <= N && count[i*3] > count[i] + 1) {
				count[i*3] = count[i] + 1;
				prev[i*3] = i;
			}
		}
		
		output.append(count[N]).append("\n");
		
		int index = N;
		for(int i = 0, size = count[N]; i <= size; i++) {
			output.append(index).append(" ");
			index = prev[index];
		}
		
		System.out.println(output);
	}
}