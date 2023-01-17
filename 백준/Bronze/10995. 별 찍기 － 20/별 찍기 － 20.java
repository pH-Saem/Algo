import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int starCount = 0;
		StringBuilder ans = new StringBuilder();
		boolean isStar = true;
		
		for(int i = 0; i < N; i++) {
			starCount = 0;
			if(i % 2 == 0) {
				isStar = true;
			}else {
				isStar = false;
			}
			
			while(starCount != N) {
				if(isStar) {
					ans.append("*");
					starCount++;
				}else {
					ans.append(" ");
				}
				isStar = !isStar;
			}
			ans.append("\n");
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
