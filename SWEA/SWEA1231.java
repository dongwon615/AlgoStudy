import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1231 {
	static int n;
	static char[] tree;
	static StringBuffer sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			int idx;
			tree = new char[n+1];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				tree[idx] = st.nextToken().charAt(0);
			}
			sb = new StringBuffer();
			sb.append("#" + t + " ");
			
			inorder(1);
			System.out.println(sb);
		}
	}
	static void inorder(int idx) {
		
		if(idx*2 <= n) {
			inorder(idx*2);
		}
		sb.append(""+tree[idx]);
		if(idx*2+1 <=n) {
			inorder(idx*2+1);
		}
	}
}
