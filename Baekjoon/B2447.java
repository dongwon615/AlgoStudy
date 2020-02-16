import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2447 {
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		drawStar(0, 0, n);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == '\u0000') {
					sb.append(" ");
				}else {
					sb.append(map[i][j]);					
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void drawStar(int x, int y, int size) {
		if(size == 1) {
			map[y][x] = '*';
			return;
		}
		size = size / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == j && i == 1) {
					continue;
				}
				drawStar(x + size * j, y + size * i, size);
			}
		}
	}
}
