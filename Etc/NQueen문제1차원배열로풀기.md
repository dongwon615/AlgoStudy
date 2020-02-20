# N-Queen 문제 코드
라인별로 같은 중복 없는것 생각은 했었으나, 1차원으로 바꿀생각은 못함.  
한줄에 하나의 퀸만 있기때문에 퀸이있는 위치를 기억해두고 dfs 돌리면 된다.  
해당라인에서 퀸이 있는지는 \ | / 이 세방향을 보면 되며, level과 i를 이용하면 쉽게 판별 가능하다.

``` java
import java.util.Arrays;

public class NQ {
	static int[] map;
	static int N;
	public static void main(String[] args) {
		N = 5;
		map = new int[N];
		dfs(0);
	}
	static int cnt;
	static void dfs(int level) {
		if(level == N) {
			cnt++;
			System.out.println("cnt : " + cnt);
			System.out.println(Arrays.toString(map));
			return;
		}
		for(int i = 0; i < N; i++) {
			map[level] = i;
			if(isPromising(level)) {
				dfs(level+1);
			}
//			map[level] = 0; //바로 다시 넣기때문에 의미없음
		}
	}
	
	static boolean isPromising(int level) {
		for(int i = 0; i < level; i++) {
			if(map[i] == map[level]) {
				return false;
			}
			if(Math.abs(map[level] - map[i]) == (level-i)) {
				return false;
			}
		}
		return true;
	}
}
```
