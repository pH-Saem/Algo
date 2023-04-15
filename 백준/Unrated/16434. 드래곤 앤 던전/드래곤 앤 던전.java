import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int MONSTER = 1, POTION = 2;
	
	static Hero hero;
	static List<Room> rooms;
	
	public static void main(String[] args) throws IOException {
		input();
		solution();
	}

	static void solution() {
		long left = 1, right = 1000000L * 1000000L * (rooms.size() + 1);
		long mid = 0, result = 0;
		
		outer : while(left < right) {
			mid = (left + right) / 2;
			hero.set(mid);
			for(Room r : rooms) {
				if(!hero.move(r)) {
					left = mid + 1;
					continue outer;
				}
			}
			result = mid;
			right = mid;
		}
		
		System.out.println(result);
	}
	
	static void input() throws IOException {
		int N, atk;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		atk = Integer.parseInt(st.nextToken());
		
		hero = new Hero(atk);
		rooms = new ArrayList<>();
		
		int t, a, h;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			rooms.add(new Room(t, a, h));
		}
		
	}
	
	static class Hero{
		long hp;
		long maxHp;
		long atk;
		int initialAtk;
		
		Hero(int atk){
			this.atk = atk;
			this.initialAtk = atk;
		}
		
		void set(long hp) {
			this.hp = hp;
			this.maxHp = hp;
			this.atk = this.initialAtk;
		}
		
		boolean move(Room room) {
			if(room.type == MONSTER) {
				if(!fight(room.atk, room.hp))
					return false;
			}else if(room.type == POTION) {
				eatPotion(room.atk, room.hp);
			}
			return true;
		}
		
		boolean fight(int a, int h) {
			long turns = h/atk - 1;
			if(h%atk != 0) turns++;
			
			hp -= a*turns;
			if(hp <= 0)
				return false;
			else
				return true;
		}
		
		void eatPotion(int a, int h) {
			this.atk += a;
			this.hp += h;
			if(this.hp > this.maxHp)
				this.hp = this.maxHp;
		}
	}
	
	static class Room{
		int type;
		int atk;
		int hp;
		
		public Room(int type, int atk, int hp) {
			this.type = type;
			this.atk = atk;
			this.hp = hp;
		}
	}
}