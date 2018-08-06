/**
 * 部分数学问题的算法
 */

public class MathAlgorithm {

    private int[] prime = new int[10000];
    
    private boolean[] isPrime = new boolean[10001];

    /**
     * 欧几里得算法求最大公约数，假设a>b
     * 复杂度为O(log(max(a,b)))
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    /**
     * 扩展欧几里得算法求解ax+by=gcd(a,b)
     * 复杂度和欧几里得算法一样
     * @param a
     * @param b
     * @return 第一个元素是gcd(a,b)，后面两个为x和y
     */
    public int[] exgcd(int a,int b){  
        int ans;  
        int[] result = new int[3];  
        if (b == 0) {  
            result[0] = a;  
            result[1] = 1;  
            result[2] = 0;  
            return result;  
        }  
        int[] temp = exgcd(b,a%b);  
        ans = temp[0];  
        result[0] = ans;  
        result[1] = temp[2];  
        result[2] = temp[1]-(a/b)*temp[2];  
        return result;  
    }

    /**
     * 埃氏筛法求n以内的素数个数
     * 复杂度O(nloglogn)
     * @param n
     * @return
     */
    public int sieve(int n) {
        int p = 0;
        for (int i = 0;i <= n;i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;
        for (int i = 2;i <= n;i++) {
            if (isPrime[i]) {
                prime[p++] = i;
                for (int j = 2*i;j <= n;j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return p;
    }

    /**
     * 快速幂
     * @param x
     * @param power
     * @return
     */
    public long pow(long x, long power) {
        long result = 1L;
        while (power > 0) {
            if (n & 1 != 0) {
                result *= x;
            }
            x *= x;
            power >>= 1;
        }
        return result;
    } 

    /**
     * 牛顿迭代法求平方根
     * 实际上思路是根据递推关系x(n+1) = x(n) - f(x(n))/f'(x(n))，当x(n+1)和x(n)足够接近时得到结果。
     * 可以用于求解多项式求值问题
     */

    public int mySqrt(int x) { 
        if (x <= 1) {
            return x;
        }
        double x1 = 0, x2 = 1; 
        while (Math.abs(x1 - x2) > 0.000001) { 
            x1 = x2; 
            x2 = x1/2 + (double)x/(2*x1); 
        } 
        return (int)x1; 
    } 
}