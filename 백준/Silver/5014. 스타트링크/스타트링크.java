import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int F, S, G, U, D, min = -1;
	static boolean isVisited[];
	static Queue<Position> queue = new ArrayDeque<>();
	
	static class Position{
		int floor;
		int count;
		
		Position(int floor, int count){
			this.floor = floor;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());					// 최고 층
		S = Integer.parseInt(st.nextToken());					// 시작 층
		G = Integer.parseInt(st.nextToken());					// 목적 층
		U = Integer.parseInt(st.nextToken());					// 위로 이동하는 층 수
		D = Integer.parseInt(st.nextToken());					// 아래로 이동하는 층 수
		
		isVisited = new boolean[F+1];
		
		if(S == G)
			min = 0;
		else {
			queue.offer(new Position(S, 0));
			isVisited[S] = true;
		}
		
		Position curPosition;
		while(!queue.isEmpty()) {
			curPosition = queue.poll();
			
			// 위로 이동
			if(moveFloor(curPosition, U))
				break;
			
			// 아래로 이동
			if(moveFloor(curPosition, -D))
				break;
		}
		
		if(min == -1)
			System.out.println("use the stairs");
		else
			System.out.println(min);
	}
	
	public static boolean moveFloor(Position curPosition, int interval) {
		int newFloor = curPosition.floor + interval;
		
		if(newFloor == G) {
			min = curPosition.count + 1;
			return true;
		}
		
		if(newFloor > 0 && newFloor <= F && !isVisited[newFloor]) {
			isVisited[newFloor] = true;
			queue.offer(new Position(newFloor, curPosition.count + 1));
		}
		
		return false;
	}
}