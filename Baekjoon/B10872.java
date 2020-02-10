import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10872 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(pactorial(n));
	}
	static int pactorial(int n) {
		if(n == 1 || n == 0) return 1;
		return n * pactorial(n-1);
	}
}
