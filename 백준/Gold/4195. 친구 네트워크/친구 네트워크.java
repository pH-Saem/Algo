import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static int T;
	static Network[] friends;
	static Map<String, Integer> people = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			solution();
		}
		System.out.println(output);
	}

	static void solution() throws NumberFormatException, IOException {
		int F = Integer.parseInt(br.readLine());
		int friendCount = 0, result;
		int[] nums = new int[2];
		String name;
		
		people.clear();
		friends = makeSet(F*2);
		
		for(int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				name = st.nextToken();
				if(!people.containsKey(name)) {
					people.put(name, friendCount++);
				}
				nums[j] = people.get(name);
			}
			
			result = unionSet(nums[0], nums[1]);
			output.append(result).append("\n");
		}
	}
	
	static Network[] makeSet(int size) {
		Network[] set = new Network[size + 1];
		for (int i = 0; i < size; i++) {
			set[i] = new Network(i);
		}
		return set;
	}

	static int findSet(int num) {
		if (num == friends[num].num)
			return num;
		else
			return friends[num].num = findSet(friends[num].num);
	}
	
	static int unionSet(int a, int b) {
		int setA = findSet(a);
		int setB = findSet(b);
		
		if(setA == setB)
			return friends[setA].count;
		else {
			friends[setA].count += friends[setB].count;
			friends[setB].num = setA;
			return friends[setA].count;
		}
	}

	static class Network {
		int num;
		int count;

		public Network(int num) {
			this.num = num;
			this.count = 1;
		}
	}
}