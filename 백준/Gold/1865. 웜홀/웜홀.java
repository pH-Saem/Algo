import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer st;

    static final long INF = 1_000_000_000;

    static int T, N, M, W;
    static List<int[]> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            init();
            solution();
        }
        System.out.println(output);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        edges.clear();
        
        // 도로 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new int[] {v1, v2, weight});
            edges.add(new int[] {v2, v1, weight});
        }

        // 웜홀 입력
        for(int i = 0; i < W; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new int[] {v1, v2, -weight});
        }
    }

    static void solution(){
        // 벨만 포드
        long[] costs = new long[N+1];
        boolean negativeCycle = false;

        Arrays.fill(costs, INF);
        costs[1] = 0;

        // v-1번 반복
        for(int v = 1; v < N; v++){
            for(int[] edge : edges){
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                if(costs[from] + weight < costs[to]){
                    costs[to] = costs[from] + weight;
                }
            }
        }

        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            if(costs[from] + weight < costs[to]){
                negativeCycle = true;
                break;
            }
        }

        if(negativeCycle)
            output.append("YES\n");
        else
            output.append("NO\n");
    }
}