import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int T, n, k;
	static List<Integer> nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		nums = new ArrayList<>();
		
		for(int t = 0; t < T; t++) {
			input();
			solution();
		}
		
		System.out.println(output);
	}
	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		nums.clear();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
	}

	// 정렬 후 투포인터로 가장 가까운 두 정수 조합의 수를 찾는다
	static void solution() {
		int left = 0, right = n-1, sum, diff;
		int minDiff = Integer.MAX_VALUE, count = 0;
		
		Collections.sort(nums);
		
		while(left < right) {
			sum = nums.get(right) + nums.get(left);
			diff = Math.abs(sum - k);

			if(diff < minDiff) {
				minDiff = diff;
				count = 1;
			}else if(diff == minDiff) {
				count++;
			}
			
			if(sum - k > 0) {
				right--;
			}else
				left++;
		}
		
		output.append(count).append("\n");
	}
}