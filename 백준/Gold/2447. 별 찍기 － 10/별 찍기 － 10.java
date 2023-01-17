import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int[][] bp = new int[N][N];
		StringBuilder ans = new StringBuilder();
		
		checkSpaceOnBP(bp, 0, 0, N);
		
		// bp에 표시한 대로 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(bp[i][j] == 1) {
					ans.append(" ");
				}else {
					ans.append("*");
				}
			}
			ans.append("\n");
		}
		
		System.out.println(ans);
	}
	
	public void checkSpaceOnBP(int[][] bp, int x, int y, int N) {
		int size = N/3, spaceX = x + size, spaceY = y + size;
		
		// 가운데에 한 변의 길이가 N/3인 정사각형 크기의 공백 bp에 표시
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				bp[spaceX + i][spaceY + j] = 1;
			}
		}
		
		// N/3 크기의 정사각형 9개에 대해 checkSpaceOnBP 실행
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(size >= 3) {
					checkSpaceOnBP(bp, x+i*size, y+j*size, size);
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

}
