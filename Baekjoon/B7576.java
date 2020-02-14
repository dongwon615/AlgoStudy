import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B7576 {
	static class Data {
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static int n, m;
	static int[][] box;
	static boolean end = true;
	static int day = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		box = new int[n][m];
		List <Data> list = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken()); 
				if(box[i][j] == 1) {
					list.add(new Data(j,i));
				}
			}
		}
		day(list);
		
		System.out.println(seeBox());;
		
	}
	static List<Data> tlist;
	static void day(List<Data> list) {
		tlist = new LinkedList<>();
		day++;
		for(Data d : list) {
			tomatoDie(d.x,d.y);
		}
		if(end) {
			day--;
			return;
		}
		
		end = true;
		day(tlist);
	}
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static void tomatoDie(int x, int y) {
		int tx,ty;
		for(int d = 0; d < 4; d++) {
			tx = x + dx[d];
			ty = y + dy[d];
			if(tx < 0 || ty <0 || tx >= m || ty >= n) {
				continue;
			}
			if(box[ty][tx] == 0) {
				box[ty][tx] = day+1;
				tlist.add(new Data(tx,ty));
				end = false;
			}
		}
	}
	static int seeBox() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(box[i][j] == 0) {
					return -1;
				}
			}
		}
		return day;
	}
}
