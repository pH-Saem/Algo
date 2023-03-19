import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int deltas[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	static String[][] nums;
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		nums = new String[5][5];
		
		for(int r = 0; r < 5; r++) {
			 nums[r] = br.readLine().split(" ");
		}
		
		for(int r = 0; r < 5; r++) {
			for(int c = 0; c < 5; c++) {
				dfs(0, "", r, c);
			}
		}
		
		System.out.println(set.size());
	}
	
	static void dfs(int count, String num, int r, int c) {
		if(count == 6) {
			set.add(num);
			return;
		}
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = r + deltas[d][0];
			nc = c + deltas[d][1];
			if(isInRange(nr ,nc)) {
				dfs(count + 1, num + nums[nr][nc], nr, nc);
			}
		}
	}
	
	static boolean isInRange(int r, int c) {
		return 0 <= r && r < 5 && 0 <= c && c < 5;
	}

}