import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int hats[] = new int[9];			// 모자에 적힌 번호들
	static int selected[] = new int[2];		// 난쟁이가 아닌 둘
	static int sum;							// 모자에 적힌 번호 총합
	static boolean isFound;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i = 0; i < 9; i++) {
			hats[i] = Integer.parseInt(br.readLine());
			sum += hats[i];
		}
		
		makeCombination(0, 0);
		
		System.out.println(output);
	}
	
	public static void makeCombination(int nthChoice, int startIdx) {
		if(isFound) return;
		
		if(nthChoice == 2) {
			if((sum - hats[selected[0]] - hats[selected[1]] == 100)) {
				for(int i = 0; i < 9; i++) {
					if(i == selected[0] || i == selected[1]) continue;
					output.append(hats[i]).append("\n");
				}
				isFound = true;
			}
			return;
		}
		
		for(int i = startIdx; i < 9; i++) {
			selected[nthChoice] = i;
			makeCombination(nthChoice + 1, i + 1);
		}
	}
}