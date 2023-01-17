import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	private static int D, R, G;
	public static void main(String[] args) throws IOException {
		int N, L, time = 0, pos = 0;
		String line;
		Main algo = new Main();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		
		StringTokenizer tokens = new StringTokenizer(line);
		N = Integer.parseInt((tokens.nextToken()));
		L = Integer.parseInt((tokens.nextToken()));

		algo.readNextSignal(br);
		
		while(pos != L) {
			if(pos == D) {
				while(time%(R+G) < R) {
					time++;
				}
				
				if(N != 1) {
					algo.readNextSignal(br);
					N--;
				}
			}
			pos++;
			time++;
		}
		
		System.out.println(time);
	}
	
	private void readNextSignal(BufferedReader br) throws IOException {
		String line = br.readLine();
		StringTokenizer tokens = new StringTokenizer(line);
		
		tokens = new StringTokenizer(line);
		D = Integer.parseInt((tokens.nextToken()));
		R = Integer.parseInt((tokens.nextToken()));
		G = Integer.parseInt((tokens.nextToken()));
	}
}
