import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer st;

    static final int WALL = 0, GROUND = 1, GOAL = 2;

    static int n, m, goalR, goalC;
    static int[][] map, result;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];

        for(int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == GOAL){
                    goalR = r;
                    goalC = c;
                }
            }
        }
    }

    static void solution(){
        int nr, nc, size, step = 0;
        int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        for(int r = 0; r < n; r++){
            Arrays.fill(result[r], -1);
        }

        queue.offer(new int[] {goalR, goalC});
        visited[goalR][goalC] = true;
        result[goalR][goalC] = 0;

        while(!queue.isEmpty()){
            size = queue.size();
            step++;

            for(int i = 0; i < size; i++) {
                int[] pos = queue.poll();

                for (int d = 0; d < 4; d++) {
                    nr = pos[0] + deltas[d][0];
                    nc = pos[1] + deltas[d][1];

                    if (isInRange(nr, nc) && !visited[nr][nc] && map[nr][nc] != WALL) {
                        visited[nr][nc] = true;

                        result[nr][nc] = step;
                        queue.offer(new int[] {nr, nc});
                    }
                }
            }
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(map[r][c] == WALL)
                    result[r][c] = 0;
            }
        }

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                output.append(result[r][c]).append(" ");
            }
            output.append("\n");
        }

        System.out.println(output);
    }

    static boolean isInRange(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < m;
    }

}