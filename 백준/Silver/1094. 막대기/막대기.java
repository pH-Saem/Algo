import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int X, count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		X = Integer.parseInt(br.readLine());
		for(int i = 0; i <= 6; i++) {
			if((X & (1 << i)) > 0) {
				count++;
			}
		}
		System.out.println(count);
	}

}