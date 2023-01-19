import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int spaceBetween = 2*N - 3;
		int space = 1;
		boolean isMiddlePass = false;
		
		appendChars(ans, "*", N);
		appendChars(ans, " ", spaceBetween);
		appendChars(ans, "*", N);
		appendChars(ans, "\n", 1);
		spaceBetween -= 2;
		
		for(int i = 1; i < 2*N-2; i++) {
			appendChars(ans, " ", space);
			appendChars(ans, "*", 1);
			appendChars(ans, " ", N-2);
			if(i == N-1) {
				appendChars(ans, "*", 1);
				isMiddlePass = true;
			}else {
				appendChars(ans, "*", 1);
				appendChars(ans, " ", spaceBetween);
				appendChars(ans, "*", 1);
			}
			appendChars(ans, " ", N-2);
			appendChars(ans, "*", 1);
			appendChars(ans, "\n", 1);
			
			if(isMiddlePass) {
				spaceBetween += 2;
				space--;
			}else {
				spaceBetween -= 2;
				space++;				
			}		
		}
		appendChars(ans, "*", N);
		appendChars(ans, " ", spaceBetween);
		appendChars(ans, "*", N);
		appendChars(ans, "\n", 1);
		
		System.out.println(ans);
	}
	
	public static void appendChars(StringBuilder sb, String c, int count) {
		for(int i = 0; i < count; i++) {
			sb.append(c);
		}
	}
	
	public static void main(String[] args) throws IOException {
		solution();
	}

}
