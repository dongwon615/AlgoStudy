
public class DisjointUnion {
	static int[] parent;
	static int n;
	//static int[] rank;

	public static void main(String[] args) {
		n = 10;
		parent = new int[n + 1];
		makeSet();
		union(2,4);
		union(5,7);
		
		union(8,9);
		union(2,9);
		
		
		System.out.println(findSet(2));
		System.out.println(findSet(4));	
		System.out.println(findSet(5));	
		System.out.println(findSet(7));	
		System.out.println(findSet(8));
		System.out.println(findSet(9));	
		System.out.println(parent[9]);
	}

	private static void union(int x, int y) {
		int tx = findSet(x);
		int ty = findSet(y);
		if(tx == ty) {
			return;
		}
	//rank가 작은거 (find 깊이가 낮은거를 높은거에 붙여야 더 최적)
		parent[ty] = tx;
		
	}

	static void makeSet() {
		for (int i = 1; i <= n; i++) {
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
}
