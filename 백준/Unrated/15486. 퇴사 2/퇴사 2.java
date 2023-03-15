import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [키워드] 
 * DP
 * 
 * [풀이과정]
 * 1. DP 테이블 생성. 인덱스 : 해당일에 없을 수 있는 최대 이익
 * 2. 입력 저장
 * 3. DP 테이블 갱신(이전 일 최대 수익 + 현재 상담 진행 시 얻을 수 있는 수익 비교 후 갱신) 
 * 
 * [입력] 
 * N 입력
 * N개의 상담 일정 입력
 * 
 * [출력] 
 * 얻을 수 있는 최대 이익
 * 
 * @author phsaem
 * @since 2023. 3. 14
 * @see https://www.acmicpc.net/problem/15486
 * @performance 
 * @category 
 */
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static Job jobs[];
	static List<Job> dp = new ArrayList<>(); 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		jobs = new Job[N+1];
		
		int duration, income;
		jobs[0] = new Job(0, 0, 0);
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			duration = Integer.parseInt(st.nextToken()) - 1;
			income = Integer.parseInt(st.nextToken());
			
			jobs[i] = new Job(i, i + duration, income);
		}
		
		Arrays.sort(jobs);
		
		Job startJob = new Job(0, 0, 0);
		int startIndex, endIndex;
		dp.add(new Job(0, 0, 0));
		
		for(int i = 1; i <= N; i++) {
			if(jobs[i].endDate > N) continue;
			
			// 시작일 전까지의 최대 수익 값 구하기
			startJob.endDate = jobs[i].startDate - 1;
			startIndex = Collections.binarySearch(dp, startJob);
			if(startIndex < 0) startIndex = startIndex * (-1) - 2;
			
			// 이전 최대 수익 + 자신의 수익으로 수익 갱신
			jobs[i].income += dp.get(startIndex).income;
			
			endIndex = Collections.binarySearch(dp, jobs[i]);
			
			// 새로운 endDate인 경우 추가
			if(endIndex < 0) {
				endIndex = endIndex * (-1) - 1;
				
				// 이전 수익보다 큰 경우에만 추가
				if(dp.get(endIndex - 1).income < jobs[i].income)
					dp.add(endIndex, jobs[i]);
			}else {
			// 같은 날 끝나는 Job이 있는 경우 -> income 비교 후 최대값 갱신
				Job other = dp.get(endIndex);
				other.income = Integer.max(other.income, jobs[i].income);
			}
		}
		
//		for(Job j : dp) {
//			System.out.printf("종료일 : %d 수익 : %d\n", j.endDate, j.income);
//		}
		
		System.out.println(dp.get(dp.size() - 1).income);
	}
	
	static class Job implements Comparable<Job>{
		int startDate;
		int endDate;
		int income;
		
		public Job(int startDate, int endDate, int income) {
			this.startDate = startDate;
			this.endDate = endDate;
			this.income = income;
		}
		
		@Override
		public int compareTo(Job o) {
			return Integer.compare(endDate, o.endDate);
		}
	}
}