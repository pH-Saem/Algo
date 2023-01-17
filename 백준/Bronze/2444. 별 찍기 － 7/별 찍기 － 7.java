import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int starCount = 1;
		StringBuilder ans = new StringBuilder();
		
		for(int i = 1; i <= 2*N-1; i++) {
			for(int j = 0; j < (N - i > 0 ? N - i : (-1)*(N - i)); j++) {
				ans.append(" ");
			}
			for(int j = 0; j < starCount; j++) {
				ans.append("*");
			}
			
			if(i < N) {
				starCount += 2;
			}else {
				starCount -= 2;
			}
			
			ans.append("\n");
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
