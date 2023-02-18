import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, sum, mods[];
	static long count, mod;
	
	public static void main(String[] args) throws IOException {
		// N, M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 초기화
		mods = new int[M];
		
		// 숫자 N개 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken()) % M;
			sum = sum % M;
			mods[sum]++;
		}
		
		count = mods[0];
		for(int i = 0; i < M; i++) {
			mod = mods[i];
			count += (mod * (mod - 1)) / 2;
		}
		
		System.out.println(count);
	}

}