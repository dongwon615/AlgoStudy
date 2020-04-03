# nCk에서 n과 k가 클때 구하는 방법
## nCk의 특징
nCk  = n! / (n-k)!k! 이다.  
이항정리 (파스칼 삼각형) 생각해보면 nCk = n-1Ck-1 + n-1Ck 이 된다.  
이를 이용하여 메모이제이션을 사용하면 되는데..  
**백준 11401번을 풀면 시간초과가 나온다.**  
n과 k가 400만이나 되기떄문..  

따라서 답을 mod p (소수) 로 요구하는 것을 생각해서 페르마의 소정리와 곱셈의 역원을 이용해야한다.  

## 페르마의 소정리와 곱셈의 역원
* 페르마의 소정리는 >  a^(p-1) == 1 (mod p) 라는 것이다. 따라서 a * a^(p-2) == 1(mod p) 이고 a의 역원은 a^(p-2)이다.
* 곱셈의 역원은 x * y = 1 인 y 를 곱셈의 역원이라고 한다.
이를 이용하여 nCk = n! / (n-k)! k! 을 계산해주면되는데...  
곱셈의 역원을 생각하면 (n-k)!k!의 역원을 n!에 곱해주면 원하는 값이 나온다는 것이다.  

역원의 값은 n!의 역원을 구하고 나면, (n-1)! 의 역원은 == n!의 역원인   n^(p-2) * (n-1)!^(p-2) 이고  
이 값에 n을 곱해주면 n ^ (p-1) 이 되며 (n-1)!^(p-2) 가 된다.

이를 이용해서 구할 수 있고 실제 코드는 백준 11401 문제에 가면 코드 있음~!

페르마정리 배워서 다시 구현된거 주석포함됨
``` java
import java.util.Scanner;
 
public class SWEA5607 {
    static int MOD = 1234567891;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, R;
        long res;
         
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            R = sc.nextInt();
             
            /**
             * nCr == nCn-r, ex)10C7 == 10C3
             */
            if(R > N /2) {
                R = N - R; 
            }

            /**
             * nCr = nPr / r!
             * 1. 구하고자 하는값 = (nPr / r!)(mod 1234567891)
             * 2. nPr과 r!을 각각 구한다.
             * 3. 모듈러 연산의 성질을 이용한다
             * 그러나,
             * (A * B)(modX) = (A(modX) * B(modX))(modX)
     			와 같이 곱셈의 경우는 성립하지만, 
     			(A / B)(modX) != (A(modX) / B(modX))(modX)
     			나눗셈에 대해서는 성립하지 않음
             * 4. 모듈러 연산의 성질을 이용하기 위해서는, 나눗셈을 곱셈으로 바꿔야 한다.
             * --> nPr / r!은 nPr * r!^-1(r!의 역원)과 같다.
             * --> 일반적인 사칙연산에서는 r!의 역원이 1/r!이지만(r! * 1/r! = 1) 모듈러 연산에선 아님
             * --> 목표 : r!의 modX에서의 모듈러 역원
             *            (r! * a)(modX) 
             *          = (r!(modX) * a(modX))(modX) 
             *          = 1(r,a는 정수)
             *          이 되는 모듈러 역원을 찾아야 한다.
             * --> r!의 모듈러 역원 중 하나를 찾으려면... 페르마의 소정리 or 유클리드 확장 알고리즘 이용 
             * 
             * 페르마의 소정리 : a의 (mod x)에 대한 모듈러 역원은 a^(x-2)이다.
             * 
             * 결과 : nCr = (nPr * r!의 역원) (mod 1234567891)
             */
            res = 1;
            for(int i = 0; i < R; i++) {
                res *= (N - i);
                res %= MOD;
            } //분모값인 nPr구하기
             
            long div = 1;
            for(int i = 1; i <= R; i++) {
                div *= i;
                div %= MOD;
            }//분자값인 r!구하기
 
            //페르마의 소정리를 이용해 분자값 r!의 모듈러 역원 구하기(=r!^(MOD - 2))
            div = pow(div, MOD - 2); //페르마의 소정리 이용
             
            res *= div; //나눗셈하는 대신 이전단계에서 구한 모듈러 역원을 이용해 곱셈 연산
            res %= MOD; //결과를 MOD로 나눈 나머지를 구함
             
            System.out.println("#" + tc + " " + res);
        }
    }
    static long pow(long base, long exp) {
        if(exp == 0)
            return 1;
         
        long res = pow(base, exp / 2);
        res *= res;
        res %= MOD;
         
        if(exp % 2 == 1) {
            return (res * base) % MOD;
        } else {
            return res;
        }
    }
}

```
