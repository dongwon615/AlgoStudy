# 프로그래머스 불량사용자 문제
## 카카오 겨울 인턴십 문제
### dfs로 완전탐색하는데, 사용되었던 조합 기억하기위해 bit 연산자 값 기억하는 chk 배열 사용한것 중심으로 보기.
``` java
package 프로그래머스;

public class P불량사용자 {
	static int rst;
	// user_id 사용체크
	static int v;
	// banned_id 사용체크
	static int b;
	// 조합 사용 check
	static boolean[] chk;
	public int solution(String[] user_id, String[] banned_id) {
		chk = new boolean[1<<user_id.length+1];
		v = 0;
		b = 0;
		rst = 0;
		dfs(user_id,banned_id,0);
		return rst;
	}
	

	private void dfs(String[] user_id, String[] banned_id, int cnt) {
		// ban이 다되면 return
		if(cnt == banned_id.length) {
			//조합 사용 체크하고 없으면 rst++;
			if(chk[v]) {
				return;
			}
			chk[v] = true;
			rst++;
		}
		//user_id 중 사용안된것을 찾아야함.
		for(int i = 0; i < user_id.length; i++) {
			//해당 비트가 0이아니면 방문했던것임
			if((v & (1 << i)) != 0) {
				continue;
			}
			//user_id가 ban_id에 맞는게 있으면 해당 ban에 해당값넣고 dfs 진행
			int ban = check(user_id[i],banned_id);
			if(ban >= 0) {
				//방문체크하고
				v = v | (1 << i);
				b = b | (1 << ban);
				dfs(user_id, banned_id, cnt+1);
				//방문체크 해제하고
				v = v & (~(1 << i));
				b = b & (~(1 << ban));
			}
		}
	}


	private int check(String uid, String[] banned_id) {
		next:
		for(int i = 0; i < banned_id.length; i++) {
			//해당 비트가 0이아니면 방문했던것임
			if((b & (1 << i)) != 0) {
				continue;
			}
			if(banned_id[i].length() == uid.length()) {
				for(int j = 0; j < uid.length(); j++) {
					//밴이 *이아니면
					if(banned_id[i].charAt(j) != '*') {
						//같아야함.
						if(banned_id[i].charAt(j) != uid.charAt(j)) {
							continue next;
						}
					}
				}
				//다같다는거니까 banned_id 의 i 번째가 사용된거임.
				return i;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		P불량사용자 solution = new P불량사용자();
		String[] u = {"frodo", "fradi", "crodo", "abc12", "frod2"};
	    String[] b = {"*****", "*****", "frod*"};
//		int rst = solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"*rodo", "*rodo", "******"});
		int rst = solution.solution(u, b);
	    System.out.println(rst);
	}
}
```
