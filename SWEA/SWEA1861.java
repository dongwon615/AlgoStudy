/*
* visit에 숫자를 기억해두고 재귀로 탐색하는방법 사용했음
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[][] map;
	static int[][] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			v = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int rst1 = 0;
			int rst2 = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n;j++) {
					if(v[i][j] == 0) {
						v[i][j] = search(i,j,1);
						if(v[i][j] >= rst2) {
							if(v[i][j] == rst2 && rst1 < map[i][j]) {
								continue;
							}
							rst2 = v[i][j];
							rst1 = map[i][j];
						}
					}
				}
			}
			System.out.println("#"+ t + " " + rst1 + " " + rst2);
			
		}
	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	private static int search(int y, int x, int depth) {
		int tx, ty;
		int rst = 0;
		for(int d = 0; d < 4; d++) {
			tx = x + dx[d];
			ty = y + dy[d];
			if(tx<0 || ty <0|| tx>=n || ty >=n) {
				continue;
			}
			if(map[ty][tx] == (map[y][x] + 1)) {
				if(v[ty][tx]!=0) {
					return v[ty][tx]+depth;
				}
				v[ty][tx] = -1;
				rst = search(ty,tx,depth+1);
				return rst;
			}
		}
		return depth;
	}
}
