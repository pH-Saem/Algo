import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int deltas[][] = {{}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	static int max;
	// space : 현재 공간의 물고기 정보를 저장할 배열
	// fishes : 물고기 이동할 때 사용할 1번부터 차례대로 저장된 배열
	
	// 물고기 정보 저장할 Fish 클래스.
	static class Fish{
		int d;
		int num;
		int r;
		int c;
		
		Fish(){}
		
		Fish(Fish fish){
			this.d = fish.d;
			this.num = fish.num;
			this.r = fish.r;
			this.c = fish.c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 1. 입력
		Fish fish, shark = new Fish();
		Fish space[][] = new Fish[4][4], fishes[] = new Fish[17];
		for(int r = 0; r < 4; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 4; c++) {
				fish = new Fish();
				space[r][c] = fish;
				fish.num = Integer.parseInt(st.nextToken());
				fish.d = Integer.parseInt(st.nextToken());
				fish.r = r;
				fish.c = c;
				fishes[fish.num] = fish;
			}
		}
		
		eatFish(space, fishes, space[0][0], shark);
		
//		이동 테스트
//		moveFishes(space, fishes, shark);
//		printSpace(space);
		
		circleOfLife(space, fishes, shark);
		
		System.out.println(max);
	}
	
	// 공간 정보 출력
	public static void printSpace(Fish[][] space) {
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c < 4; c++) {
				if(space[r][c] != null)
					System.out.print(space[r][c].num + " ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	// 물고기 이동 + 물고기 냠얌
	public static void circleOfLife(Fish[][] space, Fish[] fishes, Fish shark) {
		List<Fish> poorFishes;
		Fish newShark, newSpace[][], newFishes[];
		
		moveFishes(space, fishes, shark); 						// 물고기 이동
		poorFishes = getFishesOnSharkDirection(space, shark); 	// 상어가 먹을 수 있는 물고기 리스트 생성
		
		if(poorFishes.isEmpty()) { 								// 먹을 수 있는 물고기가 없는 경우
			max = Integer.max(max, shark.num); 					// 상어가 먹은 물고기 번호 합 최대값 갱신
			return;
		}
		
		for(Fish poorFish : poorFishes) {						// 먹을 수 있는 물고기 하나씩 먹어보기
			newSpace = new Fish[4][4];
			newFishes = new Fish[17];
			newShark = new Fish(shark);
			
			copySpaceAndFishes(space, newSpace, newFishes);		// 정보 복사
			eatFish(newSpace, newFishes, poorFish, newShark);	// 물고기 먹기
			
			circleOfLife(newSpace, newFishes, newShark);		// 다음 사이클
		}
	}
	
	// space와 fishes 복사하는 메서드
	public static void copySpaceAndFishes(Fish[][] oldSpace, Fish[][] newSpace, Fish[] newFishes) {
		Fish fish;
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c < 4; c++) {
				if(oldSpace[r][c] != null) {
					fish = new Fish(oldSpace[r][c]);
					newSpace[r][c] = fish;
					newFishes[fish.num] = fish; 
				}
			}
		}
	}
	
	// 상어가 먹을 수 있는 물고기 리스트 반환
	public static List<Fish> getFishesOnSharkDirection(Fish[][] space, Fish shark) {
		List<Fish> result = new ArrayList<>();
		int nr = shark.r, nc = shark.c;
		
		// 상어의 진행 방향으로 이동해가면서 물고기가 존재하면 리스트에 담는다.
		while(isInRange(nr, nc)) {
			if(space[nr][nc] != null) {
				result.add(space[nr][nc]);
			}
			nr += deltas[shark.d][0];
			nc += deltas[shark.d][1];
		}
		return result;
	}
	
	// 상어가 물고기를 먹는 메서드
	public static void eatFish(Fish[][] space, Fish[] fishes, Fish fish, Fish shark) {
		shark.r = fish.r;
		shark.c = fish.c;
		shark.d = fish.d;
		shark.num += fish.num;
		space[shark.r][shark.c] = null;
		fishes[fish.num] = null; 
	}
	
	// 물고기들 이동시키는 메서드
	public static void moveFishes(Fish[][] space, Fish[] fishes, Fish shark) {
		for(Fish fish : fishes) {			// 0~16번 물고기 이동 (0번의 경우 null이라 패스)
			if(fish != null) { 				// 존재하는 물고기의 경우 (안 잡아먹힌 물고기)
				moveFish(space, fish, shark);
			}
		}
	}
	
	// 물고기 이동시키는 메서드
	public static void moveFish(Fish[][] space, Fish fish, Fish shark) {
		int nr, nc, d = fish.d;
		while(true) {
			nr = fish.r + deltas[d][0];
			nc = fish.c + deltas[d][1];
			if(isInRange(nr, nc) && !isSharkSpace(nr, nc, shark)) {
				space[fish.r][fish.c] = space[nr][nc];
				if(space[nr][nc] != null) {
					space[nr][nc].r = fish.r;
					space[nr][nc].c = fish.c;
				}
				
				space[nr][nc] = fish;
				fish.r = nr;
				fish.c = nc;
				break;
			}
			d++;
			d = d > 8 ? 1 : d;
			if(d == fish.d) break; 
		}
		fish.d = d;
	}
	
	public static boolean isSharkSpace(int r, int c, Fish shark) {
		return r == shark.r && c == shark.c;
	}

	public static boolean isInRange(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}
}