import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, nums[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int div = 2, num1, num2, max;
		Arrays.sort(nums); // 오름차순 정렬
		num1 = nums[0];
		num2 = nums[1];
		
		// 가장 작은 수까지 완전 탐색
		while(div <= num1) {
			if(num1%div == num2%div) {
				if(isNumsRemainEqual(div, num1%div)) {
					ans.append(div).append(" ");
				}
			}			
			div++;
		}
		
		// 두 번째로 작은 수까지 완전 탐색
		// 이 경우 나머지는 항상 가장 작은 수여야 한다.
		max = num2 / 2;
		while(div <= max) {
			if(num1 == num2%div) {
				if(isNumsRemainEqual(div, num1)) {
					ans.append(div).append(" ");
				}
			}
			div++;
		}
		
		// num2 - num1 으로 나누는 경우 고려 (나머지가 num1이기 때문!)
		if(num2 > num1*2) {
			div = num2 - num1;
			if(isNumsRemainEqual(div, num1)) {
				ans.append(div).append(" ");
			}
		}
		
		ans.deleteCharAt(ans.length()-1);
		System.out.println(ans);
	}
	
	public static boolean isNumsRemainEqual(int div, int remain) {
		boolean isDiff = false;
		for(int i = 2; i < N; i++) {
			if(remain != nums[i]%div) {
				isDiff = true;
				break;
			}
		}
		return !isDiff;
	}

}
