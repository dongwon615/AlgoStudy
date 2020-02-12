import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215 {
	static int n;
	static int maxcal;
	static int maxgood;
	static int[][] ingredient;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			maxcal = Integer.parseInt(st.nextToken());
			
			ingredient = new int[n][2];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				ingredient[i][0] = Integer.parseInt(st.nextToken());
				ingredient[i][1] = Integer.parseInt(st.nextToken());			
			}
			maxgood = 0;
			comb(0,0,0,0);				
			System.out.println("#" + t + " " + maxgood);
		}
	}
	static void comb(int start, int cnt, int cal ,int good) {
		if(cal > maxcal) {
			return;
		}
		
		if(maxgood<good) {
			maxgood = good;
		}
		
		if(cnt == n) {
			return;
		}
		for(int i = start; i < n; i++) {
			comb(i+1,cnt+1,cal+ingredient[i][1],good+ingredient[i][0]);
		}
	}
}
