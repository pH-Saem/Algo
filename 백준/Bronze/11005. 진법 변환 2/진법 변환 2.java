import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static long N, B, mul;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		mul = 1;
		while(N >= mul) {
			mul *= B;
		}
		mul /= B;

		long num;
		while(mul > 0) {
			num = N / mul;
			N %= mul;
			mul /= B;

			if (0 <= num && num <= 9) {
				output.append(num);
			} else {
				num -= 10;
				output.append((char)('A' + num));
			}
		}

		System.out.println(output);
	}
}