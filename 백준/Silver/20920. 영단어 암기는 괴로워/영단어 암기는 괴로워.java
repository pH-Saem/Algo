import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;

	static int N, M;
	static Map<String, Word> dictionary = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		init();
		solution();
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		String word;
		for(int i = 0; i < N; i++) {
			word = br.readLine();
			if(word.length() >= M) {
				if(dictionary.containsKey(word)) {
					dictionary.get(word).count++;
				}else {
					dictionary.put(word, new Word(word));
				}
			}
		}
	}
	
	static void solution() {
		List<Word> words = new ArrayList<>(dictionary.values());
		Collections.sort(words);
		
		for(Word w : words) {
			output.append(w.word).append("\n");
		}
		
		System.out.println(output);
	}
	
	static class Word implements Comparable<Word>{
		String word;
		int length;
		int count;
		
		public Word(String word) {
			this.word = word;
			this.length = word.length();
			this.count = 0;
		}

		@Override
		public int compareTo(Word o) {
			if(count == o.count) {
				if(length == o.length) {
					return word.compareTo(o.word);
				}
				return Integer.compare(length, o.length)*(-1);
			}
			return Integer.compare(count, o.count)*(-1);
		}
	}
}