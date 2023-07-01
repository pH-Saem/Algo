import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static String word;
    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        word = br.readLine();
    }

    static void solution(){
        int left = 0;
        int right = 0;
        int totalAlpha = 0;
        int longestLen = 0;
        int[] alphabets = new int[26];
        char[] chars = word.toCharArray();

        while(right < chars.length){
            int index = chars[right++] - 'a';
            if(alphabets[index]++ == 0)
                totalAlpha++;

            while(totalAlpha > N){
                index = chars[left++] - 'a';
                if(--alphabets[index] == 0)
                    totalAlpha--;
            }

            longestLen = Integer.max(longestLen, right - left);
        }

        System.out.println(longestLen);
    }

}