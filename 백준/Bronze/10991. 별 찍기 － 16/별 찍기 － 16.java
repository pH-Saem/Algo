import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int spaceCount = N - 1;
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < spaceCount; j++) {
				ans.append(" ");
			}
			ans.append("*");
			for(int j = 0; j < i; j++) {
				ans.append(" *");
			}
			ans.append("\n");
			spaceCount--;
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
