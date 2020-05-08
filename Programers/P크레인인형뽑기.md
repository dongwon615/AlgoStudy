# 프로그래머스 크레인인형뽑기
## 카카오 겨울인턴문제
### 그냥 스택만들어서 넣고 빼고,, 하면 됨. 중간에 empty 검사하고 pop 및 peek하는것만 신경쓰면되고, 0일때 안넣어주는것 정도만 고려하면 끝.
``` java
import java.util.Stack;

public class P크레인인형뽑기 {
	public int solution(int[][] board, int[] moves) {
        //뽑기머신 정의
		int w = board[0].length;
		int h = board.length;
		Stack<Integer> [] machine = new Stack[w];
		for (int i = 0; i < w; i++) {
        	machine[i] = new Stack<>();
        }
        //뽑기머신 안에 숫자 넣기
        for (int i = h-1; i >=0; i--) {
        	for (int j = 0; j < w; j++) {
        		//인형이면 넣기
        		if (board[i][j] != 0) {
        			machine[j].push(board[i][j]);
        		}
        	}
        }
        //move에 의해 인형 옮겨서 결과 rst stack에 넣기.
        Stack<Integer> rst = new Stack<>();
        int ret = 0;
        int doll;
        for (int i = 0; i < moves.length; i++) {
        	if(machine[moves[i]-1].isEmpty()) {
        		continue;
        	}
        	doll = machine[moves[i]-1].pop();
        	if (!rst.isEmpty()) {
        		if (doll == rst.peek()) {
        			rst.pop();
        			ret+=2;
        			continue;
        		}
        	}
        	rst.push(doll);
        }
        return ret;
    }
	
	public static void main(String[] args) {
		P크레인인형뽑기 solution = new P크레인인형뽑기();
		int ret = solution.solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4});
		System.out.println(ret);
	}
}
```
