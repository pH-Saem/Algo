import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] usingMemory, costs, dp;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        usingMemory = new int[N];
        costs = new int[N];
        dp = new int[10001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            usingMemory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution(){
        for(int i = 0; i < N; i++){
            int cost = costs[i];
            int memory = usingMemory[i];
            for(int c = 10000; c >= cost; c--){
                dp[c] = Integer.max(dp[c], dp[c - cost] + memory);
            }
        }

        int minCost = 0;
        for(int i = 10000; i >= 0; i--){
            if(dp[i] >= M) minCost = i;
        }

        System.out.println(minCost);
    }

}