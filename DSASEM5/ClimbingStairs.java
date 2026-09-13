import java.util.Arrays;

class ClimbingStairs {
   
    private int solve(int n,int dp[]){
        if(n<0) return 0;
        if(n==0 || n==1) return 1;
        
        if(dp[n]!=-1) return dp[n];

        int op1=solve(n-2,dp);
        int op2=solve(n-1,dp);
        return dp[n]=op1+op2;
    }

    public int climbStairs(int n) {
       int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);

    }
}