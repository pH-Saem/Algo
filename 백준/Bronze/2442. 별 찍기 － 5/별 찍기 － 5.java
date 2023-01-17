import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder ans = new StringBuilder();
		int N = Integer.parseInt(str);
		int starCount = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < N - i; j++) {
				ans.append(" ");
			}
			for(int j = 0; j < starCount; j++) {
				ans.append("*");
			}
			ans.append("\n");
			starCount += 2;

		}
		System.out.println(ans);
	}

}
