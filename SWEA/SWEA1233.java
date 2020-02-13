import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233 {
	static int n;
	static int[] tree;
	static int rst;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			int idx;
			tree = new int[n + 1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				tree[idx] = st.nextToken().charAt(0)-'0';
			}
			rst = 1 ;
			preorder(1);
			System.out.println("#" + t + " " + rst);
		}
	}

	static void preorder(int idx) {
		if (tree[idx] > 0) {
			if(idx*2 <= n) {
				rst= 0;
				return;
			}
		}
		if(idx*2 <= n) {
			preorder(idx*2);
		}

		if(idx*2 <= n) {
			preorder(idx*2+1);
		}

	}
}
