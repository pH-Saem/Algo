import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static List<Integer> lis = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		int index, num;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			index = Collections.binarySearch(lis, num);
			if(index < 0) index = (index * (-1)) - 1;
			if(index == lis.size()) {
				lis.add(num);
			}else {
				lis.set(index, num);
			}
		}
		
		System.out.println(lis.size());
	}

}