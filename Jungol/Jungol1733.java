import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol1733 {
	static int[][] map;
	static int rst;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[20][20];
		for(int i = 1; i < 20; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean isprint = false;
		out : for(int i = 1; i < 20; i++) {
			for(int j = 1; j < 20; j++) {
				if(map[i][j] != 0) {
					if(iswin(j, i, map[i][j])) {
						System.out.println(map[i][j]);
						System.out.println(ty+" "+tx);
						isprint =true;
						break out;
					}					
				}
			}
		}
		if(!isprint) {
			System.out.println(0);
		}
	}
	static int[] dx = {1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1};
	static int tx,ty;
	
	static boolean iswin(int x, int y, int dol) {
		
		for(int d = 0; d < 4; d++) {
			int cnt = 0;
			tx = x;
			ty = y;
			while(true) {
				tx = tx + dx[d];
				ty = ty + dy[d];
				if(tx < 0 || ty < 0|| tx >= 20 || ty >= 20) {
					break;
				}
				if(map[ty][tx] != dol) {
					break;
				}
			}
			
			while(true) {
				tx = tx - dx[d];
				ty = ty - dy[d];
				if(tx < 0 || ty < 0|| tx >= 20 || ty >= 20) {
					break;
				}
				if(map[ty][tx] != dol) {
					break;
				}
				cnt++;
			}
			
			if(cnt == 5) {
				tx = tx + dx[d];
				ty = ty + dy[d];
				return true;
			}
		}
		return false;
	}
}
