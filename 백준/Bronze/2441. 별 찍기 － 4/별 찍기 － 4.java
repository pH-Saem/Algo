import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder ans = new StringBuilder();
		int N = Integer.parseInt(str);
		int starCount = N;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - starCount; j++) {
				ans.append(" ");
			}
			for(int j = 0; j < starCount; j++) {
				ans.append("*");
			}
			ans.append("\n");
			starCount--;
		}
		System.out.println(ans);
	}

}
