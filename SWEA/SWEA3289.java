import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289 {
	static int parent[];
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		int m;
		int o,a,b;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			makeSet();
			sb.append("#" + t + " ");
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				o = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(o == 0) {
					Union(a, b);
				}else {
					sb.append(isUnion(a, b));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void makeSet(){
		for(int i = 1; i <=n; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == parent[x]) {
			return x;
		}
		parent[x] = findSet(parent[x]);
		return parent[x];
	}
	static int isUnion(int x, int y) {
		int tx = findSet(x);
		int ty = findSet(y);
		if(tx == ty) {
			return 1;
		}
		return 0;
	}
	static void Union(int x, int y) {
		int tx = findSet(x);
		int ty = findSet(y);
		if(tx == ty) {
			return;
		}
		parent[tx] = ty;
	}
}
