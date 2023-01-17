import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int spaceBetween = 1;
		StringBuilder ans = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			for(int spaceCount = N-i; spaceCount > 0; spaceCount--) {
				ans.append(" ");
			}
			if(i == 1) {
				ans.append("*");
			}else if(i == N) {
				for(int starCount = 1; starCount <= 2*N-1; starCount++) {
					ans.append("*");
				}
			}else {
				ans.append("*");
				for(int j = 0; j < spaceBetween; j++) {
					ans.append(" ");
				}
				ans.append("*");
				spaceBetween += 2;
			}
			ans.append("\n");
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
