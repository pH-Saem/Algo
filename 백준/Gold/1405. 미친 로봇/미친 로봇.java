import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static double[] directionPercent;
    static double simplePercent = 0;
    static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        directionPercent = new double[4];

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 4; i++){
            directionPercent[i] = (Double.parseDouble(st.nextToken()) / 100);
        }
    }

    static void solution(){
        boolean[][] visited = new boolean[2*N + 1][2*N + 1];
        visited[N][N] = true;
        dfs(new Status(1, N, N, 0, visited));
        System.out.printf("%.10f\n", simplePercent);
    }

    static void dfs(Status cur){
        if(cur.moveCount == N){
            simplePercent += cur.percent;
            return;
        }

        int nr, nc;
        for(int d = 0; d < 4; d++){
            nr = cur.r + deltas[d][0];
            nc = cur.c + deltas[d][1];

            if(!cur.visited[nr][nc]){
                cur.visited[nr][nc] = true;
                dfs(new Status(cur.percent * directionPercent[d], nr, nc, cur.moveCount + 1, cur.visited));
                cur.visited[nr][nc] = false;
            }
        }
    }

    static class Status{
        double percent;
        int r, c;
        int moveCount;
        boolean[][] visited;

        public Status(double percent, int r, int c, int moveCount, boolean[][] visited) {
            this.percent = percent;
            this.r = r;
            this.c = c;
            this.moveCount = moveCount;
            this.visited = visited;
        }
    }
}