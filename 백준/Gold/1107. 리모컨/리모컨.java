import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, minCount, nLength;
    static List<Integer> buttons;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        Set<Integer> brokenButtons = new HashSet<>();
        buttons = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if(M != 0)
            st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            brokenButtons.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < 10; i++){
            if(brokenButtons.contains(i)) continue;
            buttons.add(i);
        }
    }

    static void solution(){
        minCount = Math.abs(100 - N);

        int n = N;
        if(n == 0) nLength = 1;
        else{
            while(n > 0){
                n /= 10;
                nLength++;
            }
        }

        if(!buttons.isEmpty()) {
            makePermutation(1, 0, 0);
            checkSmaller();
            checkBigger();
        }

        System.out.println(minCount);
    }

    static void makePermutation(int cur, int channel, int count){
        if(nLength == count){
            minCount = Integer.min(minCount, Math.abs(N - channel) + count);
            return;
        }
        for(int num : buttons){
            makePermutation(cur * 10, channel + cur * num, count + 1);
        }
    }

    static void checkSmaller(){
        if(nLength - 1 == 0) return;

        int num = buttons.get(buttons.size()-1);
        int result = 0;

        for(int i = 0; i < nLength - 1; i++){
            result = result * 10 + num;
        }

        minCount = Integer.min(minCount, nLength - 1 + Math.abs(N - result));
    }

    static void checkBigger(){
        int num = buttons.get(0);
        int result = 0;

        for(int i = 0; i < nLength + 1; i++){
            if(i == 0 && num == 0 && buttons.size() >= 2) {
                result += buttons.get(1);
                continue;
            }
            result = result * 10 + num;
        }

        minCount = Integer.min(minCount, nLength + 1 + Math.abs(N - result));
    }

}