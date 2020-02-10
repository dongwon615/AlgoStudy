//SWEA 1247번 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static Data sp;
	static Data ep;
	static Data[] house;
	static boolean[] v;
	static int n;
	static int rst = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			rst = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			sp = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			ep = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Data[n];
			v = new boolean[n];
			for (int i = 0; i < n; i++) {
				house[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < n; i++) {
				search(sp, 0, 0);
			}
			System.out.println("#" + t + " " + rst);
		}
	}

	static void search(Data st, int far, int cnt) {
		
		if (cnt == n) {
			far += Math.abs(st.x - ep.x) + Math.abs(st.y - ep.y);
			if (rst > far) {
				rst = far;
			}
			return;
		}
		int ifar = far;

		for (int i = 0; i < n; i++) {
			if (v[i]) {
				continue;
			}
			v[i] = true;
			far += Math.abs(st.x - house[i].x) + Math.abs(st.y - house[i].y);
			if (far >= rst) {
				v[i] = false;
				return;
			}
			search(house[i], far, cnt + 1);
			v[i] = false;
			far = ifar;
		}
	}

	static class Data {
		int x, y;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
