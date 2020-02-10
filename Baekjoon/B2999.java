import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 2999번 문제 비밀이메일

//4 by 4로만들면
//0 4 8 12 / 1 5 9 13 / 2이런식으로 접근해서 돌리면됨
//2 by 8로 만들면
//abcdefghijklmnop
//abcdefgh
//ijklmnop
//거쳐서 aibjckdlemfngohp
//이래오니까
//0 2 4 6 8 10 12 14 / 1 3 이런식으로 접근


public class B2999 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] crr = br.readLine().toCharArray();
		int n = 0;
		n = crr.length;
		int r = 1, c;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				r = i;
			}
		}
		c = n / r;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < r; i++) {
			for(int j = i; j < n; ) {
				sb.append(crr[j]);
				j = j + r;
			}
		}
		System.out.println(sb);
	}
}
