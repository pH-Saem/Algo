import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static int T, C;
	
	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		
		int q = 25, d = 10, n = 5, p = 1;
		int Q, D, N, P;
		for(int t = 0; t < T; t++) {
			C = Integer.parseInt(br.readLine());
			
			Q = C / q;
			C = C % q;
			
			D = C / d;
			C = C % d;
			
			N = C / n;
			C = C % n;
			
			P = C;
			
			output.append(Q).append(" ").append(D).append(" ").append(N).append(" ").append(P).append("\n");
		}
		
		System.out.println(output);
	}
}