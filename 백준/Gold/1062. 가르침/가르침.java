import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K; 					// N : 단어의 개수 K : 가르칠 글자의 수
	static int learn; 					// 배운 글자 (비트로 표시)
	static int words[] = new int[50]; 	// 단어의 글자 정보 배열 (비트로 표시)
	static int max;
	static int basic = 1 | (1 << 'c' -'a') | (1 << 'i' - 'a') | (1 << 'n' - 'a') | (1 << 't' -'a'); // 필수 단어!
//	static int needToTeach; 			// 가르칠 글자 후보 (단어에 나올 시 비트로 표시)
	
	public static void main(String[] args) throws IOException {
//		System.out.println(Integer.toBinaryString(basic));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 1. 단어 입력 받고 각 단어에 사용된 알파벳 비트에 저장
		// 2. 단어에 나온 알파벳들 따로 저장
		int alphabet;
		for(int i = 0; i < N; i++) {
			alphabet = 0;
			for(char ch : br.readLine().toCharArray()) {
//				needToTeach = needToTeach | (1 << ch - 'a');// 모든 단어에 나온 알파벳 저장
				alphabet = alphabet | (1 << ch - 'a');		// 이번 단어에 나온 알파벳 저장
			}
			words[i] = alphabet;							// 단어별로 나온 알파벳 저장
		}
		// 3. 단어에 나온 알파벳들로 조합 생성
		// 4. 알파벳 조합으로 단어들 읽을 수 있는 지 개수 세고 최대값 저장
		//		읽은 수 있는 지 여부 판별 : | ^ 연산으로 수행
		makeAlphabetCombination(0, 0, basic);
		
		// 5. 최대값 출력
		System.out.println(max);
	}
	
	// 가르칠 문자 조합을 만들고 읽을 수 있는 단어 개수를 확인하는 함수  
	public static void makeAlphabetCombination(int nthChoice, int startIdx, int choice) {
		if(nthChoice == K-5) {		// 알파벳을 K-5개 만큼 선택한 경우 (이미 a, c, i, n, t 선택했기 때문)
			int count = 0, temp;
			// 읽을 수 있는 단어 개수 확인
			for(int i = 0; i < N; i++) {
				temp = choice | words[i];
				temp = temp ^ choice;
				if(temp == 0) {
					count++; 
				}
			}
			// 최대값 갱신
			max = Integer.max(max, count);
			return;
		}
		
		// n번째 알파벳 선택
		for(int i = startIdx; i < 26; i++) {
			if((choice & (1 << i)) > 0) continue;	// 이미 선택한 문자의 경우 넘긴다.
			makeAlphabetCombination(nthChoice + 1, i + 1, choice | (1 << i));
		}
		
	}

}