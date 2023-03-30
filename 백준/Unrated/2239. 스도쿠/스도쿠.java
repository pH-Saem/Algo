import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static String line;
	static int[][] doku;
	static int[] R, C, S;
	static boolean isFinish = false;
	
	public static void main(String[] args) throws IOException {
		doku = new int[9][9];
		R = new int[9];
		C = new int[9];
		S = new int[9];
		
		for(int r = 0; r < 9; r++) {
			line = br.readLine();
			for(int c = 0; c < 9; c++) {
				doku[r][c] = line.charAt(c) - '0';
				R[r] |= 1 << doku[r][c];
				C[c] |= 1 << doku[r][c];
				S[3*(r/3) + c/3] |= 1 << doku[r][c];
			}
		}
		
		dfs(0, 0);
		
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				output.append(doku[r][c]);
			}
			output.append("\n");
		}
		System.out.println(output);
		
	}
	
	static void dfs(int r, int c) {
		if(isFinish) return;
		
		if(r == 9 && c == 0) {
			isFinish = true;
			return;
		}
		
		if(doku[r][c] == 0) {
			int candidate = R[r] | C[c] | S[3*(r/3) + c/3];	// 해당 행, 열, 박스에서 나온 수들 비트마스크
			for(int i = 1; i <= 9; i++) {
				if((candidate & 1 << i) == 0) {				// 아직 안 나온 수인 경우 넣어본다 
					R[r] |= 1 << i;
					C[c] |= 1 << i;
					S[3*(r/3) + c/3] |= 1 << i;
					
					doku[r][c] = i;
					
					if(c + 1 == 9) 
						dfs(r + 1, 0);
					else
						dfs(r, c + 1);
					
					if(isFinish) return;
					
					doku[r][c] = 0;
					
					R[r] ^= 1 << i;
					C[c] ^= 1 << i;
					S[3*(r/3) + c/3] ^= 1 << i;
				}
			}
		}else {
			if(c + 1 == 9) 
				dfs(r + 1, 0);
			else
				dfs(r, c + 1);
		}
		
	}

}