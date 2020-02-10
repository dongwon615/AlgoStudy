import java.util.Scanner;
 
public class Main {
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int[] result;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        result = new int[n];
         
        solve(0,0,m);
         
    }
 
    public static void solve(int cnt, int sum, int m) {
        if(cnt == result.length) {
            if(sum == m) {
                for(int i = 0; i < result.length; i++) {
                    System.out.print(result[i] + " ");
                }
                System.out.println();               
            }
            return ;
        }
        for(int i = 0; i < dice.length; i++) {
            result[cnt] = dice[i];
            solve(cnt+1,sum+dice[i],m);
        }
    }
 
}
