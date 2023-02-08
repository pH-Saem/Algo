import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		makePermutation(1, 2); // 첫 자리는 나머지 자리와 다르게 2가 추가, 1, 9가 제외되므로 따로 처리
		for(int i = 3; i < 9; i += 2) {
			makePermutation(1, i);
		}
		
		System.out.println(output);
	}

	public static boolean isPrime(int num) {
		int div = 3; // 홀수이므로 3부터 나누어 본다!
		
		for(int max = (int)Math.sqrt(num)+1; div <= max; div += 2) {
			if(num % div == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void makePermutation(int nthChoice, int permutation) {
		if(nthChoice == N) {
			output.append(permutation).append("\n");
			return;
		}
		for(int num = 1; num < 10; num += 2) { // 3부터 홀수만 체크
			if(isPrime(permutation * 10 + num)) {
				makePermutation(nthChoice + 1, permutation * 10 + num);
			}
		}
	}
}