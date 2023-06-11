import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, longestLen;
    static int[] nums;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];
        counts = new int[100001];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void solution(){
        int head = 0, tail = 0, num, len = 0;

        while(tail < N){
            num = nums[tail++];
            len++;

            if(counts[num] == K){
                while(nums[head] != num){
                    counts[nums[head++]]--;
                    len--;
                }
                head++;
                len--;
            }else{
                counts[num]++;
            }
            
            longestLen = Integer.max(len, longestLen);
        }

        System.out.println(longestLen);
    }

}