import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int wnum;
	static int lnum;
	static int[] mycard;
	static int[] yourcard;
	static int[] compcard;
	static boolean[] v;
	static int n = 9;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		boolean[] cardlist;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= tc; t++) {
			cardlist = new boolean[19];
			wnum = lnum = 0;
			mycard = new int[n];
			yourcard = new int[n];
			compcard = new int[n];
			v = new boolean[n];
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				mycard[i] = Integer.parseInt(st.nextToken());
				cardlist[mycard[i]] = true;
			}
			int ti = 0;
			for (int i = 1; i < 2*n+1; i++) {
				if (cardlist[i]) {
					continue;
				}
				yourcard[ti++] = i;
			}
			
			search9(0);
			sb.append(String.format("#%d %d %d\n", t, wnum,lnum));
			
		}
		System.out.print(sb);
	}

	static void search9(int cnt) {
		if (cnt == n) {
			iswin();
			//System.out.println(Arrays.toString(compcard));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i]) {
				continue;
			}
			v[i] = true;
			compcard[cnt] = yourcard[i];
			search9(cnt+1);
			v[i] = false;
		}

	}

	static void iswin() {
		int mysum, yoursum;
		mysum = yoursum = 0;
		for (int i = 0; i < n; i++) {
			if (mycard[i] < compcard[i]) {
				yoursum += mycard[i] + compcard[i];
			} else {
				mysum += mycard[i] + compcard[i];
			}
		}
		if(mysum > yoursum) {
			wnum++;
		}
		if(mysum < yoursum) {
			lnum++;
		}

	}
}
