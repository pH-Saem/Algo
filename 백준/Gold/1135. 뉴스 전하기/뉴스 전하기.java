import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static Person[] staffs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		solution();
		System.out.println(staffs[0].minTime);
	}

	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		staffs = new Person[N];
		for (int i = 0; i < N; i++) {
			staffs[i] = new Person(i);
		}

		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int num;
		for (int i = 1; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			staffs[i].boss = num;
			staffs[num].addStaff(staffs[i]);
		}
	}
	
	static void solution() {
		Queue<Person> queue = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			if(staffs[i].degree == 0)
				queue.offer(staffs[i]);
		}
		
		Person cur;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			
			cur.calcMinTime();
			
			if(--staffs[cur.boss].degree == 0) {
				queue.offer(staffs[cur.boss]);
			}
		}
	}

	static class Person implements Comparable<Person> {
		int num;
		int boss;
		int degree; 			// 부하직원 수
		int minTime;			// 부하직원까지 모두 연락하기까지 필요한 최소 시간
		List<Person> staff;

		public Person(int num) {
			this.num = num;
			this.degree = 0;
			this.minTime = 0;
			this.staff = new ArrayList<>();
		}
		
		void addStaff(Person p) {
			staff.add(p);
			degree++;
		}

		void calcMinTime() {
			int time = 1;
			
			// 부하직원들을 필요한 시간 기준 내림차순으로 정렬.
			Collections.sort(staff);
			
			// 긴 시간을 요구하는 직원 순으로 연락을 하고 최소 시간을 계산한다.
			// (부하직원이 없는 경우 0으로 유지된다.) 
			for(Person p : staff) {
				minTime = Integer.max(minTime, p.minTime + time++);
			}
		}
		
		@Override
		public int compareTo(Person o) {
			return Integer.compare(minTime, o.minTime) * (-1);
		}
	}

}