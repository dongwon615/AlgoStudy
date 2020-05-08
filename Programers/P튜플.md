# 프로그래머스 튜플 문제
## 카카오 겨울 인턴십 문제
### String 조작 관련, StringTokenizer로 어떤방식으로 나눌지 잘 확인하고, pq통해서 원하는 조건의 String 받아오고, 사용번호 check 배열통해서 한것 확인
``` java
package 프로그래머스;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P튜플 {
    public int[] solution(String s) {
    	PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
    	//}기준으로 나눠서 넣으면 제일 뒤에 }} 뒤에는 나눠서 아무것도 없어서 안읽고 나머지는 {{ or ,{ 붙여서 들어가있음
    	StringTokenizer st = new StringTokenizer(s,"}");
    	while(st.hasMoreTokens()) {
    		pq.offer(st.nextToken());
    	}
    	//pq안에 들은거 개수가 원소수임
    	int[] answer = new int[pq.size()];
    	
    	//제일 짧은거 나옴. 앞에 두개 떼고 쓰면됨.
    	int cnt = 0;
    	String ts;
    	int ti = 0;
    	boolean[] chk = new boolean[100001];
    	while(!pq.isEmpty()) {
    		ts = pq.poll();
    		//{} 떼고 ,로 나눠서 숫자 구함
    		st = new StringTokenizer(ts.substring(2, ts.length()),",");
    		//여태껏 넣은것중에 있는지 확인해야함...
    		for(int i = 0; i < cnt+1; i++) {
    			ti = Integer.parseInt(st.nextToken());
    			if(!chk[ti]) {
    				break;
    			}
    		}
    		//넣은게 아닌걸 사용체크하고 넣기
    		chk[ti] = true;
    		answer[cnt++] = ti;
    	}
    	return answer;
    }
	public static void main(String[] args) {
		P튜플 solution = new P튜플();
		solution.solution("{{20,111},{111}}");
	}
}
```
