import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int S, count, gender, num, printCount, sw[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder ans = new StringBuilder();
		
		S = Integer.parseInt(br.readLine());
		sw = new int[S+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= S; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}
		
		count = Integer.parseInt(br.readLine());
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				boy(num);
			}else if(gender == 2) {
				girl(num);
			}
			
			
		}
		
		for(int i = 1; i <= S; i++) {
			if(printCount != 0) {
				ans.append(" ");
			}
			ans.append(sw[i]);
			printCount++;
			
			if(printCount == 20) {
				printCount = 0;
				ans.append("\n");
			}
		}
		System.out.println(ans);
	}
	
	public static void toggleSwitch(int index) {
		if(sw[index] == 1) {
			sw[index] = 0;
		}else {
			sw[index] = 1;
		}
	}
	
	public static boolean isIn(int index) {
		return index > 0 && index <= S;
	}
	
	public static void boy(int num) {
		int index = num;
		while(index <= S) {
			toggleSwitch(index);
			index += num;
		}
	}
	
	public static void girl(int num) {
		int li = num - 1, ri = num + 1;
		toggleSwitch(num);
		while(isIn(li) && isIn(ri)) {
			if(sw[li] == sw[ri]) {
				toggleSwitch(li--);
				toggleSwitch(ri++);
			}else {
				break;
			}
		}
	}

}
