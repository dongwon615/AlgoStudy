//백준 4963번  섬의 개수 문제
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] v;
	
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			if(w==0 && h==0) {
				break;
			}
			map = new int[h][w];
			v = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int landnum = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						landnum++;
						searchLand(i,j);
					}
				}
			}
			System.out.println(landnum);
			
		}
	}
	static void searchLand(int y, int x) {
		Queue<Data> q = new LinkedList<>();
		
		Data d = new Data(x,y);
		v[d.y][d.x] = true;
		q.offer(d);
		
		int tx, ty;
		while(!q.isEmpty()) {
			d = q.poll();
			for(int i = 0; i < 8; i++) {
				tx = d.x + dx[i];
				ty = d.y + dy[i];
				
				if(tx >= w || ty >= h || tx <0 || ty <0) {
					continue;
				}
				if(map[ty][tx] == 0 || v[ty][tx]) {
					continue;
				}
				v[ty][tx] = true;
				q.offer(new Data(tx,ty));
				
			}
			
			
		}
		
		
		
		
	}
	
	static class Data{
		int x, y;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
