import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer st;

    static int R, C, K;
    static boolean[][] paper;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        paper = new boolean[R][C];

        int r1, c1, r2, c2;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            c1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            for(int r = r1; r < r2; r++){
                for(int c = c1; c < c2; c++){
                    paper[r][c] = true;
                }
            }
        }
    }

    static void solution(){
        List<Integer> emptySpaces = new ArrayList<>();

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(!paper[r][c]){
                    emptySpaces.add(calcEmptySpaceSize(r,c));
                }
            }
        }

        Collections.sort(emptySpaces);

        output.append(emptySpaces.size()).append("\n");
        for(int size : emptySpaces){
            output.append(size).append(" ");
        }
        System.out.println(output);
    }

    static int calcEmptySpaceSize(int r, int c){
        int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] {r, c});
        paper[r][c] = true;

        int[] pos;
        int nr, nc, size = 1;
        while(!queue.isEmpty()){
            pos = queue.poll();

            for(int d = 0; d < 4; d++){
                nr = pos[0] + deltas[d][0];
                nc = pos[1] + deltas[d][1];

                if(isInRange(nr, nc) && !paper[nr][nc]){
                    paper[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                    size++;
                }
            }
        }

        return size;
    }

    static boolean isInRange(int r, int c){
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}