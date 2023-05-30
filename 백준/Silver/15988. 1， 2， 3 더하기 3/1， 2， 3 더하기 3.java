import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    static final int DIVIDER = 1_000_000_009;

    static int T, n, count;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        dp = new int[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 1_000_001; i++){
            count = (dp[i-3] + dp[i-2]) % DIVIDER;
            count = (count + dp[i-1]) % DIVIDER;
            dp[i] = count;
        }

        for(int t = 0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            output.append(dp[n]).append("\n");
        }

        System.out.println(output);
    }
}