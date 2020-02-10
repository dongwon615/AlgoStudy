//백준 8320번 문제 직사각형을 만드는 방법
//소인수 갯수 구해서 홀수면 /2+1 짝수면 /2하면 만듥수있는 사각형개수임

import java.util.Scanner;

public class B8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += canSquare(i); 
		}
		System.out.println(sum);
	}

	static int canSquare(int num) {
		int rst = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				rst++;
			}
		}
		if (rst % 2 == 0) {
			return rst / 2;
		}
		return rst / 2 + 1;
	}
}
