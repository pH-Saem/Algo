import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int INF = 1_000_000_000;

    static int n, m, r;
    static int[][] map;
    static int[] items;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 지역별 아이템 개수
        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        map = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(map[i], INF);
        }

        // 지역 연결 정보
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            map[a][b] = l;
            map[b][a] = l;
        }
    }

    static void solution(){
        for(int i = 1; i <= n; i++){
            map[i][i] = 0;
        }

        for(int k = 1; k <= n; k++){
            for(int s = 1; s <= n; s++){
                for(int e = 1; e <= n; e++){
                    if(map[s][e] > map[s][k] + map[k][e])
                        map[s][e] = map[s][k] + map[k][e];
                }
            }
        }

        int maxItem = 0, item = 0;
        for(int i = 1; i <= n; i++){
            item = 0;
            for(int j = 1; j <= n; j++){
                if(map[i][j] <= m){
                    item += items[j];
                }
            }
            maxItem = Integer.max(maxItem, item);
        }

        System.out.println(maxItem);
    }

}