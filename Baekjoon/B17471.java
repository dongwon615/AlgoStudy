/*
 * 두구역으로 나누어서
 * 그구역이 서로 연결되어있으면 
 * 인구수 차이 확인해보기
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B17471 {
	static int n;
	static int[] p;
	static int[][] map;
	static boolean[] select;
	static boolean[] visit;
	static int suma1,suma2;
	static int rst;
	static boolean done;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		p = new int[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1; i <=n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new int[n+1][n+1];
		select = new boolean[n+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int fj = Integer.parseInt(st.nextToken());
			for(int j = 0; j < fj; j++) {
				map[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}
		
		rst = Integer.MAX_VALUE;
		done = false;
		
		for(int e = 1; e <= n/2; e++) {
			comb(1,e,0);
		}
		if(done) {
			System.out.println(rst);
		}else {
			System.out.println(-1);
		}
		
	}
	
	static void comb(int startpoint, int endcnt, int cnt){
		if(cnt == endcnt) {
			visit = new boolean[n+1];
			suma1 = bfs(true);
			suma2 = bfs(false);
			//계산을 해야하는가 확인해서 ㄱ
			calc(suma1,suma2);
			return;
		}
		for(int i = startpoint; i <= n; i++) {
			select[i] = true;
			comb(i+1,endcnt,cnt+1);
			select[i] = false;
		}
	}
	
	static void calc(int a1, int a2) {
		for(int i = 1; i <= n; i++) {
			if(!visit[i]) {
				return;
			}
		}
		done = true;
		if(rst > Math.abs(a1-a2)) {
			rst = Math.abs(a1-a2);
		}
	}

	static int bfs(boolean area){
		Queue<Integer> q = new LinkedList<>();
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			if(select[i] == area) {
				visit[i] = true;
				q.add(i);
				sum += p[i];
				break;
			}
		}
		int crnt;
		while(!q.isEmpty()) {
			crnt = q.poll();
			for(int i = 1; i <=n; i++) {
				if(map[crnt][i] == 0) {
					continue;
				}
				if(visit[i]) {
					continue;
				}
				if(select[i] != area) {
					continue;
				}
				sum += p[i];
				visit[i] = true;
				q.offer(i);
			}
		}
		return sum;
	}
}
