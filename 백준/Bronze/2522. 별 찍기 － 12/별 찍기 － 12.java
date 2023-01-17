import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int spaceCount = N;
		boolean flag = true;
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < N*2-1; i++) {
			if(flag) {
				spaceCount--;
			}else {
				spaceCount++;
			}
			
			for(int j = 0; j < spaceCount; j++) {
				ans.append(" ");
			}
			for(int j = 0; j < N - spaceCount; j++) {
				ans.append("*");
			}
			
			if(spaceCount == 0) {
				flag = false;
			}
			
			ans.append("\n");
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
