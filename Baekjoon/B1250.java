import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 10250번 문제

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int rst = 0;
			if(n % h == 0) {
				rst = h * 100 + n / h;
			}else {
				rst = n % h * 100 + n / h + 1;				
			}
			
			System.out.println(rst);
		}
	}
}
