import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int starCount = 2 * N - 1;
		StringBuilder ans = new StringBuilder();
		
		for(int i = N; i >= 1; i--) {
			for(int j = 0; j < N - i; j++) {
				ans.append(" ");
			}
			for(int j = 0; j < starCount; j++) {
				ans.append("*");
			}
			ans.append("\n");
			starCount -= 2;
		}
		System.out.println(ans);		
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
