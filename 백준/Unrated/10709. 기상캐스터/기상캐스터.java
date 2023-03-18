import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * 
 * [풀이과정] 
 * 
 * [입력] 
 * 
 * [출력] 
 * 
 * @author 박한샘
 * @since 2023. 
 * @see 
 * @performance 
 * @category 
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int H, W;
	static boolean[][] clouds;
	static String line;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		clouds = new boolean[H][W];
		
		for(int r = 0; r < H; r++) {
			line = br.readLine();
			for(int c = 0; c < W; c++) {
				if(line.charAt(c) == '.') 
					clouds[r][c] = false;
				else 
					clouds[r][c] = true;
			}
		}
		
		int minute;
		for(int r = 0; r < H; r++) {
			minute = -1;
			for(int c = 0; c < W; c++) {
				if(clouds[r][c]) 
					minute = 0;
				else if(minute >= 0) 
					minute++;
				output.append(minute).append(" ");
			}
			output.append("\n");
		}
		
		System.out.println(output);
	}

}