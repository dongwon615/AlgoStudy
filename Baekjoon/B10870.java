import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10870 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibo(n));;
	}
	static int fibo(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		return fibo(n-1) + fibo(n-2);
	}
}
