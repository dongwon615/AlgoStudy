import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//백준 17413번문제 단어뒤집기2
/*
 * 문자열 전체 토크나이즈해놓고
 * <만나면  >만날떄까지 달리고,
 * 그냥 문자받으면 역순으로 바꿔. 스택에 넣으면 되겠네 ㅇㅅㅇ
 * 스택빌때까지 넣어
*/
public class B17413 {
	
	static Stack<Character> stk;
	static StringBuffer sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ct = br.readLine().toCharArray();
		
		boolean notdo = false;
		
		
		stk = new Stack<>(); 
		sb = new StringBuffer();
		boolean stackon = false;
		int idx = 0;
		while(true) {
			if(idx == ct.length) {
				break;
			}
			
			if(!notdo) {
				if(ct[idx] == '<') {
					if(stackon) {
						saveStack();
						stackon = false;
					}
					notdo = true;
					sb.append(ct[idx++]);
					continue;
				}
				if(!(ct[idx] == ' ')) {
					stackon = true;
					stk.push(ct[idx++]);
					continue;
				}
				saveStack();
				sb.append(ct[idx++]);
				stackon = false;
				continue;
			}
			sb.append(ct[idx]);
			if(ct[idx] == '>') {
				notdo = false;
			}
			idx++;
		}
		
		// 나와서 스택안에 남아있는거 있으면 append
		saveStack();
		System.out.println(sb);
	}
	
	static void saveStack() {
		while(true) {
			if(stk.isEmpty()) {
				break;
			}
			sb.append(stk.pop());
		}
	}
}
