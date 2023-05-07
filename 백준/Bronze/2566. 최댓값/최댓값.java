import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static int[] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int max = -1, row = 0, col = 0, num;
		
		for(int r = 1; r <= 9; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= 9; c++) {
				num = Integer.parseInt(st.nextToken());
				
				if(num > max) {
					max = num;
					row = r;
					col = c;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(row + " " + col);
	}
	
	
}