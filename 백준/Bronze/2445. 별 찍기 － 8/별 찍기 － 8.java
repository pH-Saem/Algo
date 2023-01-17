import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int starCount;
		StringBuilder ans = new StringBuilder();
		
		for(int i = 1; i <= 2 * N - 1; i++) {
			if(i <= N) {
				starCount = i;
			}else {
				starCount = 2*N - i;
			}
			
			appendCharsToString(ans, '*', starCount);
			appendCharsToString(ans, ' ', 2*N - 2*starCount);
			appendCharsToString(ans, '*', starCount);
			appendCharsToString(ans, '\n', 1);
		}
		
		System.out.println(ans);
	}
	
	public static StringBuilder appendCharsToString(StringBuilder sb, char c, int count) {
		for(int i = 0; i < count; i++) {
			sb.append(c);
		}
		return sb;
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
