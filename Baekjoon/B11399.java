import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 11399번문제 ATM

/*
정렬해서 그냥 걸린시간 더하면됨.
1 2 3 3 4
1 3 6 9 13
1 4 10 19 32

*/
public class B11399 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		
		int wait = 0;
		int sum = 0; 
		for(int i = 0; i < n; i++) {
			wait += p[i];
			sum+=wait;
		}
		System.out.println(sum);
	}
}
