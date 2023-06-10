import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, X, maxVisitor, count;
    static int[] visitors;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visitors = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            visitors[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution(){
        int visitorCount = 0;

        for(int i = 0; i < X; i++){
            visitorCount += visitors[i];
        }

        maxVisitor = visitorCount;
        count = 1;

        int front = 0;
        for(int i = X; i < N; i++){
            visitorCount = visitorCount - visitors[front++] + visitors[i];
            if(visitorCount > maxVisitor){
                maxVisitor = visitorCount;
                count = 1;
            }else if(visitorCount == maxVisitor){
                count++;
            }
        }

        if(maxVisitor == 0) {
            System.out.println("SAD");
        }else{
            System.out.println(maxVisitor);
            System.out.println(count);
        }
    }
}