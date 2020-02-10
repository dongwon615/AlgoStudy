/*
 * 반드시 기억하기!!!!
 * 지금 스위치문 다 쓴거 해결하는방법 >
 * char[] look = {'>','v','<',^}; 해두면 전차위치 바로 0번이런식으로 넣을수있음
 * 또한 int[] swap = new int[128];  해두고
 * swqp['R'] = swap['>'] = 0
 * swqp['D'] = swap['v'] = 1
 * swqp['L'] = swap['<'] = 2
 * swqp['U'] = swap['^'] = 3 해두면 쉽게 전환들이 가능하다!!
 * 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
	static class Tank{
		int x;
		int y;
		int dir; // 0,1,2,3 == 오 아래 왼 위
		public Tank(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	static char[][] map;
	static Tank tk;
	static int h,w,order;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		String stemp;
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];

			for(int i = 0; i < h; i++) {
				stemp = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = stemp.charAt(j);
					switch(map[i][j]) {
					case '>' :
						tk = new Tank(j,i,0);
						break;
					case 'v' :
						tk = new Tank(j,i,1);
						break;
					case '<' :
						tk = new Tank(j,i,2);
						break;
					case '^' :
						tk = new Tank(j,i,3);
						break;
					}
				}
			}
			order = Integer.parseInt(br.readLine());
			stemp = br.readLine();
			char co;
			for(int o = 0; o < order; o++) {
				co = stemp.charAt(o);
				switch(co) {
				case 'S' :
					shoot();
					break;
				case 'R' :
					move(0);
					break;
				case 'D' :
					move(1);
					break;
				case 'L' :
					move(2);
					break;
				case 'U' :
					move(3);
					break;
				}
			}
			switch(tk.dir) {
			case 0:
				map[tk.y][tk.x] = '>'; 
				break;
			case 1:
				map[tk.y][tk.x] = 'v'; 
				break;
			case 2:
				map[tk.y][tk.x] = '<'; 
				break;
			case 3:
				map[tk.y][tk.x] = '^'; 
				break;
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	static void shoot() {
		int tx = tk.x;
		int ty = tk.y;
		while(true) {
			tx += dx[tk.dir];
			ty += dy[tk.dir];
			if(tx<0||ty<0||tx>=w||ty>=h) {
				break;
			}
			if(map[ty][tx] == '*') {
				map[ty][tx] = '.';
				break;
			}
			if(map[ty][tx] == '#') {
				break;
			}
		}
	}
	
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static void move(int d) {
		int tx = tk.x + dx[d];
		int ty = tk.y + dy[d];
		tk.dir = d;
		if(tx<0||ty<0||tx>=w||ty>=h) {
			return;
		}
		if(map[ty][tx] == '.') {
			map[tk.y][tk.x] = '.';
			tk.x = tx;
			tk.y = ty;
		}
	}
}
