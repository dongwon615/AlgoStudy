import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2606 {
	static int n;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int a,b;
		makeSet();
		for(int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b =Integer.parseInt(st.nextToken());
			union(a, b);
		}
		int cnt = 0;
		int virus = find(1);
		for(int i = 2; i <= n; i++) {
			if(find(i) == virus) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	static void makeSet() {
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parent[i] =  i;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y){
		int tx = find(x);
		int ty = find(y);
		if(tx == ty) {
			return;
		}
		parent[tx] = ty;
	}
}
