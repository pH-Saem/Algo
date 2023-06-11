import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S, M;
    static int[] diff;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        diff = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            diff[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N+1][M+1];
    }

    static void solution(){
        dp[0][S] = true;

        for(int i = 0; i < N; i++){
            for(int j = 0; j <= M; j++){
                if(!dp[i][j]) continue;

                if(j - diff[i] >= 0)
                    dp[i + 1][j - diff[i]] = true;
                if(j + diff[i] <= M)
                    dp[i + 1][j + diff[i]] = true;
            }
        }

        int maxVolume = -1;
        for(int i = M; i >= 0; i--){
            if(dp[N][i]){
                maxVolume = i;
                break;
            }
        }

        System.out.println(maxVolume);
    }
}