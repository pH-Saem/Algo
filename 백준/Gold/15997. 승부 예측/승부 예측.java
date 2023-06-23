import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer st;

    static final int WIN = 0, DRAW = 1, LOSE = 2;

    static Map<String, Integer> countryIndexMap;
    static int countryCount = 0;
    static List<int[]> matches;
    static double[] nextRoundPercentage;
    static double[][] winPercentage;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        countryIndexMap = new HashMap<>();
        matches = new ArrayList<>();

        while(st.hasMoreTokens()){
            countryIndexMap.put(st.nextToken(), countryCount++);
        }

        nextRoundPercentage = new double[countryCount];
        winPercentage = new double[countryCount][countryCount];

        int matchCount = (countryCount - 1) * countryCount / 2;
        for(int i = 0; i < matchCount; i++){
            st = new StringTokenizer(br.readLine());
            int countryA = countryIndexMap.get(st.nextToken());
            int countryB = countryIndexMap.get(st.nextToken());

            double percentage;

            percentage = Double.parseDouble(st.nextToken());
            winPercentage[countryA][countryB] = percentage;

            st.nextToken();

            percentage = Double.parseDouble(st.nextToken());
            winPercentage[countryB][countryA] = percentage;
        }
    }

    static void solution(){
        makeMatches(0, new int[2], 0);

        makeMatchResults(0, new int[matches.size()]);

        for(int i = 0; i < countryCount; i++){
            output.append(String.format("%.10f\n", nextRoundPercentage[i]));
        }

        System.out.println(output);
    }

    static void makeMatches(int nthChoice, int[] selected, int startIndex){
        if(nthChoice == 2){
            matches.add(new int[]{selected[0], selected[1]});
            return;
        }

        for(int i = startIndex; i < countryCount; i++){
            selected[nthChoice] = i;
            makeMatches(nthChoice + 1, selected, i + 1);
        }
    }

    static void makeMatchResults(int nthMatch, int[] result){
        if(nthMatch == matches.size()){
            calcPercentage(result);
            return;
        }

        for(int i = 0; i < 3; i++){
            result[nthMatch] = i;
            makeMatchResults(nthMatch + 1, result);
        }
    }

    static void calcPercentage(int[] result){
        double percentage = 1;
        Score[] scores = new Score[countryCount];

        for(int i = 0; i < countryCount; i++){
            scores[i] = new Score(i, 0);
        }

        for(int i = 0; i < matches.size(); i++){
            int[] match = matches.get(i);
            int countryA = match[0];
            int countryB = match[1];

            if(result[i] == WIN){
                percentage *= winPercentage[countryA][countryB];
                scores[countryA].score += 3;
            }else if(result[i] == DRAW){
                percentage *= (1 - winPercentage[countryA][countryB] - winPercentage[countryB][countryA]);
                scores[countryA].score += 1;
                scores[countryB].score += 1;
            }else {
                percentage *= winPercentage[countryB][countryA];
                scores[countryB].score += 3;
            }
        }

        Arrays.sort(scores);

        if(scores[1].score != scores[2].score){
            nextRoundPercentage[scores[0].index] += percentage;
            nextRoundPercentage[scores[1].index] += percentage;
        }else{
            int startIndex = 1, endIndex = 2;

            if(scores[0].score == scores[1].score) {
                startIndex = 0;
                percentage *= 2;
            }else
                nextRoundPercentage[scores[0].index] += percentage;

            while(endIndex < countryCount && scores[endIndex].score == scores[1].score){
                endIndex++;
            }

            percentage /= (endIndex - startIndex);
            for(int i = startIndex; i < endIndex; i++){
                nextRoundPercentage[scores[i].index] += percentage;
            }
        }
    }

    static class Score implements Comparable<Score>{
        int index;
        int score;

        public Score(int index, int score){
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Score o) {
            return Integer.compare(score, o.score)*(-1);
        }
    }
}