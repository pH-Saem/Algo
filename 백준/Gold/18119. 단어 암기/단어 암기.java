import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer st;

    static final int FORGET = 1, REMEMBER = 2;

    static int N, M;
    static boolean[][] wordAlphabets;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wordAlphabets = new boolean[N][26];
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            for(char ch : word.toCharArray()){
                wordAlphabets[i][ch - 'a'] = true;
            }
        }
    }

    static void solution() throws IOException {
        int[] wordUnknownAlphabetCount = new int[N];
        int knownWordCount = N;

        for(int q = 0; q < M; q++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int alphabetIndex = st.nextToken().charAt(0) - 'a';

            if(command == FORGET){
                for(int i = 0; i < N; i++){
                    if(wordAlphabets[i][alphabetIndex] && wordUnknownAlphabetCount[i]-- == 0){
                        knownWordCount--;
                    }
                }
            }else if(command == REMEMBER){
                for(int i = 0; i < N; i++){
                    if(wordAlphabets[i][alphabetIndex] && ++wordUnknownAlphabetCount[i] == 0){
                        knownWordCount++;
                    }
                }
            }

            output.append(knownWordCount).append("\n");
        }

        System.out.println(output);
    }

}