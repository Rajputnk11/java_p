package DynamicProgramming;
 public class fib { 
    public static int fibonacci(int n,int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n]!=-1) return dp[n];
       dp[n]=fibonacci(n-1,dp)+fibonacci(n-2,dp);
        System.out.println(dp[n]);
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        int dp[]=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        fibonacci(n,dp);
    }
}
