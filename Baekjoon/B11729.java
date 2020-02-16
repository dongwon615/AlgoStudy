import java.io.BufferedReader;
import java.io.InputStreamReader;


public class B11729 {
	static StringBuilder sb;
	static int rst = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		hanoi(n,1,2,3);
		System.out.println(rst);
		System.out.println(sb);		
	}
	static void hanoi(int n, int from, int by, int to) {
		if(n == 1) {
			move(from, to);
			rst++;
		}else {
			hanoi(n - 1, from, to, by);
			move(from, to);
			rst++;
			hanoi(n - 1, by, from, to);
		}
	}
	static void move(int from, int to) {
		sb.append(from + " " + to + "\n");
	}
}
