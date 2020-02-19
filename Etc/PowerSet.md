# 부분집합 구하는 방법 두가지
## dfs를 이용하여 앞에꺼부터 들어가고 안들어가고 재귀 부르는방법

``` java
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
```
## 비트를 이용해서 2^n-1까지 비트가 1인것을 선택하는 것

이부분을 유심히 보면 좋을 것 같음 ( bit mask를 이용한 예시로 좋은것 같음 )

``` java
import java.util.ArrayList;
import java.util.List;

public class Pow {
	static char[] datas = {'A','B','C','D','E'};

	public static void main(String[] args) {
		List<Character> list = new ArrayList<>();
		int size = 1 << datas.length;
		for(int i = 0; i < size; i++) {
			list.clear();
			for(int j = 0; j < datas.length; j++) {
				if((i & (1 << j)) != 0) {
					list.add(datas[j]);
				}
			}
			System.out.println((i) + " " + list);
		}
	}
}

```
