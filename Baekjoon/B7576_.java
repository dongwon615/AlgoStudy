import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
	static int day = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		box = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();

		System.out.println(seeBox());

	}

	static Queue<Data> q;

	static void bfs() {
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					q.offer(new Data(j, i));
				}
			}
		}

		int oneday = q.size();
		int cnt = 0;

		while (!q.isEmpty()) {
			tomatoDie(q.poll());
			cnt++;
			if (cnt == oneday) {
				day++;
				cnt = 0;
				oneday = q.size();
			}
		}
		day--;
	}

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static void tomatoDie(Data td) {
		int tx, ty;
		for (int d = 0; d < 4; d++) {
			tx = td.x + dx[d];
			ty = td.y + dy[d];
			if (tx < 0 || ty < 0 || tx >= m || ty >= n) {
				continue;
			}
			if (box[ty][tx] == 0) {
				box[ty][tx] = 1;
				q.offer(new Data(tx, ty));
			}
		}
	}

	static int seeBox() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
			}
		}
		return day;
	}
}
