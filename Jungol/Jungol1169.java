import java.util.Scanner;
 
public class Main {
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        result = new int[n];
        visited = new boolean[6];
         
        if(m == 1) solve1(0);
        if(m == 2) solve2(0,0);
        if(m == 3) solve3(0);
         
    }
 
    public static void solve1(int cnt) {
        if(cnt == result.length) {
            for(int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return ;
        }
        for(int i = 0; i < dice.length; i++) {
            result[cnt] = dice[i];
            solve1(cnt+1);
        }
    }
 
     
    public static void solve2(int begin, int cnt) {
        if(cnt == result.length) {
            for(int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return ;
        }
        for(int i = begin; i < dice.length; i++) {
            result[cnt] = dice[i];
            solve2(i,cnt+1);
        }
    }
     
    public static void solve3(int cnt) {
        if(cnt == result.length) {
            for(int i = 0; i < result.length; i++) {
                System.out.print(result[i]+ " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < dice.length ; i++) {
            if(!visited[i]) {
                result[cnt] = dice[i];
                visited[i] = true;
                solve3(cnt+1);
                visited[i] = false;
            }
        }
    }
}
