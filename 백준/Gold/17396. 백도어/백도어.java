import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<Edge>[] edges;

    static class Edge implements Comparable<Edge>{
        int from, to;
        long weight;

        Edge(int from, int to, long weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        boolean[] sight;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N];
        sight = new boolean[N];

        for(int i = 0; i < N; i++){
            edges[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sight[i] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
        }
        sight[N-1] = false;

        int v1, v2, weight;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            if(sight[v1] || sight[v2]) continue;

            edges[v1].add(new Edge(v1, v2, weight));
            edges[v2].add(new Edge(v2, v1, weight));
        }
    }

    static void solution(){
        System.out.println(dijkstra());
    }

    static long dijkstra(){
        Queue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        long[] dist = new long[N];
        Edge cur;

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        pq.offer(new Edge(0, 0, 0));

        while(!pq.isEmpty()){
            cur = pq.poll();
            if(visited[cur.to]) continue;

            visited[cur.to] = true;
            for(Edge e : edges[cur.to]){
                if(!visited[e.to] && dist[e.to] > dist[e.from] + e.weight){
                    dist[e.to] = dist[e.from] + e.weight;
                    pq.offer(new Edge(e.from, e.to, dist[e.to]));
                }
            }
        }

        return dist[N-1] == Long.MAX_VALUE ? -1 : dist[N-1];
    }
}