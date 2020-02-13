import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15652 {
	static int n;
	static int m;
	static int[] rst;
	static StringBuffer sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuffer();
		rst = new int[m];
		recur(1, 0);
		System.out.println(sb);
	}
	private static void recur(int s, int cnt) {
		if(cnt == m) {
			printrst();
			return;
		}
		for(int i = s; i <= n; i++) {
			rst[cnt] = i;
			recur(i,cnt+1);
		}
	}
	private static void printrst() {
		for(int i = 0; i < m; i++) {
			sb.append(rst[i] + " ");
		}
		sb.append("\n");
	}
	
}
