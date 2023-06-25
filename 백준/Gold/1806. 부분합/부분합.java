import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution(){
        int left = 0, right = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while(right < N){
            sum += nums[right++];

            while(sum >= S){
                minLength = Integer.min(minLength, right - left);
                sum -= nums[left++];
            }
        }

        if(minLength == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(minLength);
    }
}