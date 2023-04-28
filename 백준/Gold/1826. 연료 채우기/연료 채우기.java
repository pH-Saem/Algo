import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, destination, curFuel;
	static Station[] stations;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		solution();
	}
	
	static void init() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		stations = new Station[N];
		
		int location, fuel;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			location = Integer.parseInt(st.nextToken());
			fuel = Integer.parseInt(st.nextToken());
			
			stations[i] = new Station(location, fuel);
		}
		
		st = new StringTokenizer(br.readLine());
		destination = Integer.parseInt(st.nextToken());
		curFuel = Integer.parseInt(st.nextToken());
	}
	
	static void solution() {
		int stopCount = 0;
		
		// 주유소 연료 순 내림차순 정렬 PQ
		Queue<Station> pq = new PriorityQueue<>(new Comparator<Station>() {
			@Override
			public int compare(Station o1, Station o2) {
				return Integer.compare(o1.fuel, o2.fuel)*(-1);
			}
		});
		
		// 주유소 거리 기준 오름차순 정렬
		Arrays.sort(stations, new Comparator<Station>() {
			@Override
			public int compare(Station o1, Station o2) {
				return Integer.compare(o1.location, o2.location);
			}
		});
		
		int index = 0;
		while(curFuel < destination) {
			while(index < N && stations[index].location <= curFuel) {
				pq.offer(stations[index++]);
			}
			
			if(pq.isEmpty()) break;
			
			stopCount++;
			curFuel += pq.poll().fuel;
		}
		
		if(curFuel < destination)
			System.out.println(-1);
		else
			System.out.println(stopCount);
	}
	
	static class Station{
		int location;
		int fuel;
		
		public Station(int location, int fuel) {
			this.location = location;
			this.fuel = fuel;
		}
	}
}