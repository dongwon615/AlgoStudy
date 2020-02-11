
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Jungol1863{
    static int n;
    static List<Integer>[] map;
    static boolean[] v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
        	map[i] = new ArrayList<>();
        }
        v = new boolean[n+1];
        int e = Integer.parseInt(st.nextToken());
        int a,b;
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        int rst = 0;
        for(int i = 1; i <= n; i++) {
            if(!v[i]) {
                rst++;
                bfs(i);
            }
        }
        System.out.println(rst);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        v[start] = true;
        q.offer(start);
        int crnt;
        while(!q.isEmpty()) {
            crnt = q.poll();
            for(int f : map[crnt]) {
                if(v[f]) {
                    continue;
                }
                v[f] = true;
                q.offer(f);
            }
        }
    }
}
