
public class PowerSet {
	static int n = 3;
	static int[] arr = {0,3,5,7};
	static boolean[] v = new boolean[n+1];
	public static void main(String[] args) {
		powerSet(0, 0);
	}
	
	static void powerSet(int cnt, int sum) {
		// !! 여기서 가지치기!!!
		if(sum > 10) {
			return;
		}
		
		// 종료조건
		if(cnt == n) {
			for(int i = 1; i <=n; i++) {
				if(v[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		//해당번째가 안들어가고
		powerSet(cnt+1, sum);
		v[cnt+1] = true;
		//들어가고
		powerSet(cnt+1,sum+arr[cnt+1]);
		v[cnt+1] = false;
	}
}
