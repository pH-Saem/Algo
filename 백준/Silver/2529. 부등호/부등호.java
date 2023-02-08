import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean isSelected[] = new boolean[10];
	static int permutation[];
	static int k;
	static boolean isGreater[]; // 부등호 정보 저장할 배열. < : false > : true
	static List<String> permutations = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		isGreater = new boolean[k];
		permutation = new int[k+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			if(st.nextToken().equals("<")) {
				isGreater[i] = false;
			}else {
				isGreater[i] = true;
			}
		}
		
		// 순열을 만들어서 부등호 조건을 만족하는 순열 결과 리스트에 저장
		makePermutations(0);
		// 리스트 정렬.
		Collections.sort(permutations);
		// 최대, 최소 출력
		System.out.println(permutations.get(permutations.size() - 1));
		System.out.println(permutations.get(0));
	}
	
	public static boolean isValid(int prevPermutationIndex, int num) {
		if(prevPermutationIndex < 0) { // 이전 인덱스가 0보다 작을 경우
			return true;
		}else if(isGreater[prevPermutationIndex] ) { // 부등호가 > 인 경우
			return permutation[prevPermutationIndex] > num;
		}else{ // 부등호가 < 인 경우
			return permutation[prevPermutationIndex] < num;
		}
	}
	
	public static void makePermutations(int permutationIndex) {
		if(permutationIndex == k + 1) { // 조건을 만족하는 순열이 만들어진 상황
			// 결과 리스트에 저장
			String result = "";
			for(int num : permutation) {
				result += num;
			}
			permutations.add(result);
			return;
		}
		
		for(int i = 0, size = isSelected.length; i < size; i++) {
			// 아직 선택하지 않은 수가 부등호 조건을 만족하는 경우 순열에 추가
			if((isSelected[i] == false) && isValid(permutationIndex - 1, i)) {
				permutation[permutationIndex] = i; // 순열에 선택한 수 저장
				isSelected[i] = true; // 사용된 수로 체크
				makePermutations(permutationIndex +1); // 다음 수 선택
				isSelected[i] = false; // 체크 해제
			}
		}
	}

}