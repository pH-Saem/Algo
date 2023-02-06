import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, full;
	static StringBuilder ans = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mkSequence(0, 0, "");
		
		System.out.println(ans);
	}
	
	public static void mkSequence(int check, int count, String prevSeq) {
		String seq; // 결과 String.
		int idx = 1; // 사용한 지 체크할 숫자의 비트마스크
		
		if(count == M) {
			ans.append(prevSeq.trim()).append("\n");
		}else {
			for(int i = 1; i <= N; i++, idx = idx << 1) {
				if((check & idx) == 0) { // 아직 사용하지 않은 숫자인 경우	
					seq = prevSeq + " " + i; // 결과 String에 추가
					mkSequence(check | idx, count+1, seq); // 사용한 숫자를 체크하고 다음 숫자 선택
				}
			}
		}
	}
	
}