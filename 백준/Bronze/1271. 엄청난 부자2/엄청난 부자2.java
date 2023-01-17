import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger n, m;
		n = new BigInteger(st.nextToken());
		m = new BigInteger(st.nextToken());
		BigInteger[] ans = n.divideAndRemainder(m);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

}
