## MST 문제!  SWEA 1251번 문제 - 하나로 

### 크루스칼 알고리즘 & 프림 알고리즘으로 풀수있음 / Kruskal 알고리즘 & Prim 알고리즘

Kruskal 알고리즘을 이용한 구현

1. edge를 오름차순으로 정렬하고 작은순서로 사용

2. 노드를 연결을 할때 Cycle이 되지 않아야 됨

   Union을 통해서 노드가 같은 집단인지 확인해야함. edge를 선택했을때 양끝노드가 같은집합이면 Cycle이니 버리고 다음 작은 edge를 사용.

``` java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA1251 {
	static class Node {
		long x;
		long y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge {
		int n1;
		int n2;
		double dis;

		public Edge(int n1, int n2, double dis) {
			this.n1 = n1;
			this.n2 = n2;
			this.dis = dis;
		}
	}

	static int n;
	static int e;
	static Node nodes[];
	static Edge[] edges;
	static int parent[];
	static double env;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			nodes = new Node[n];
			e = n * (n - 1) / 2;
			edges = new Edge[e];
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			env = Double.parseDouble(br.readLine());

			parent = new int[n];
			
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));
				//Union make
				parent[i] = i;
			}
			// 엣지생성완료
			int idx = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					edges[idx++] = new Edge(i, j, dis(nodes[i], nodes[j]));
				}
			}
			// edge를 distance 순으로 정리
			Arrays.sort(edges, new Comparator<Edge>() {

				@Override
				public int compare(Edge o1, Edge o2) {
					return Double.compare(o1.dis, o2.dis);
				}
			});

			// kruskal 알고리즘
			// 작은엣지부터 넣고, 사이클 만들어지지 않게 > 유니온해서 같은집합이아니어야함.
			Double sum = 0.0;
			int cnt = 0;
			for (int i = 0; i < e; i++) {
				if (cnt == n - 1) {
					break;
				}
				// 다 방문되면 끝
//				System.out.println(edges[i].dis);
				if (union(edges[i].n1, edges[i].n2)) {
					sum += edges[i].dis;
					cnt++;
				}
			}
			System.out.println("#" + t + " " + Math.round(sum));
		}
	}

	private static boolean union(int n1, int n2) {
		n1 = find(n1);
		n2 = find(n2);
		if (n1 == n2) {
			// 같은집합에 속함.
			return false;
		}
		parent[n1] = n2;
		return true;
	}

	private static int find(int n1) {
		if (parent[n1] == n1) {
			return n1;
		}
		return find(parent[n1]);
	}

	private static double dis(Node node1, Node node2) {
		long dis = (node1.x - node2.x) * (node1.x - node2.x)
				+ (node1.y - node2.y) * (node1.y - node2.y);
		return dis * env;
	}
}

```

Prim 알고리즘을 이용한 구현

1. 아무 하나의 노드를 mst그룹에 넣는다.

2. mst그룹에서 인접한 노드중 edge가 가장 작은 것을 선택하여 연결된 노드를 mst그룹에 넣는다

   priority queue를 사용하여 mst에 포함되지 않은 애들을 관리하는데, 이를 distance 값을 무한대에서 새로운 노드가 추가될때마다 작은값으로 변환해주면 poll을 하면 인접한 노드중 edge가 가장 작은 노드를 얻을 수 있음.  

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1251 {
	static class Node {
		long x;
		long y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge {
		int idx;
		double dis;

		public Edge(int idx, double dis) {
			this.idx = idx;
			this.dis = dis;
		}
	}

	static int n;
	static int e;
	static Node nodes[];
	static double[][] edges;
	static int parent[];
	static double env;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1, st2;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			nodes = new Node[n];
			edges = new double[n][n];
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			env = Double.parseDouble(br.readLine());

			parent = new int[n];
			
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));
			}
			// 엣지생성완료
			int idx = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					edges[i][j] = edges[j][i] = dis(nodes[i], nodes[j]);
				}
			}
			
			System.out.println("#" + t + " " + Math.round(prim(0)));
		}
	}

	private static double prim(int start) {
		// 아무 노드부터 시작

		//mst에 들어가있지 않은것들 넣을거임
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.dis,o2.dis);
			}
		});
		//모든 노드의 값을 관리
		Edge[] dynamicGraph = new Edge[n];
		
		for(int i=0; i<dynamicGraph.length; i++) {
			dynamicGraph[i] = new Edge(i, Double.MAX_VALUE);
			//pq.add(dynamicGraph[n]);
			if(i==start) {
				dynamicGraph[i].dis = 0;
			}
			pq.offer(dynamicGraph[i]);
		}
		
		double cost = 0;
		
		while(!pq.isEmpty()) {
			Edge front = pq.poll();// MST에 포함되는 녀석
			
			cost += front.dis;
			
			// 자식 탐색
			for(int i=0; i<dynamicGraph.length; i++) {
				Edge child =  dynamicGraph[i];
				// pq에는 비 MST인 Node만 존재함. 
				if(pq.contains(child)) {
					double tempCost = edges[front.idx][child.idx];
					if(tempCost < child.dis) {
						child.dis = tempCost;
						pq.remove(child);
						pq.offer(child);
					}
				}
			}
		}
		return cost;
	}

	private static double dis(Node node1, Node node2) {
		long dis = (node1.x - node2.x) * (node1.x - node2.x)
				+ (node1.y - node2.y) * (node1.y - node2.y);
		return dis * env;
	}
}

```
