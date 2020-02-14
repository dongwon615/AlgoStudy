import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA7465 {
	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		int a,b;
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			makeSet();
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			int cnt = 0;
			HashSet<Integer> rst = new HashSet();
			for(int i = 1; i <= n; i++) {
				rst.add(find(i));
			}
			System.out.println("#" + t + " " + rst.size());
			
		}
	}
	private static void union(int x, int y) {
		int tx = find(x);
		int ty = find(y);
		if(tx == ty) {
			return;
		}
		parent[tx] = ty;
		
	}
	private static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	private static void makeSet() {
		parent = new int[n+1];
		for(int i = 1; i <= n ; i++) {
			parent[i] = i;
		}
	}
}
