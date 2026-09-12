import java.util.Arrays;
import java.util.Scanner;

class Knapsack1{
    // tabulation method
    static int solve1(int cp,int wt[], int pr[],int dp[][]){
        int m=wt.length;
        for(int i=1; i<m; i++){
            for(int col=1; col<=cp; col++){
                int skip=dp[i-1][col];
                int select=0;
                if(wt[i]<=col){
                    select=pr[i]+dp[i-1][col-wt[i]];
                }
                dp[i][col] =Math.max(skip,select);
            }
        }
        return dp[m-1][cp];
    }

    // recurtion methond
    static int solve(int i, int cp, int[] wt, int[] pr,int[][] dp){
        if(i==0 || cp==0) return 0;
        
        if(i==1){
            if(wt[i]<=cp)
                return pr[i];
            else
                return 0;
        }
        // dp case check
        if(dp[i][cp]!=-1) return dp[i][cp];

        int skip=solve(i-1,cp,wt,pr,dp);
        int select=0;
        if(wt[i]<=cp){
            select=pr[i]+solve(i-1,cp-wt[i],wt,pr,dp);
        }

        return dp[i][cp]= Math.max(skip,select);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // number of item
        int n=sc.nextInt();
        // capsiti 
        int cp=sc.nextInt();
        int wt[]=new int[n+1];
        int pr[]=new int[n+1];
        
        for(int i=1; i<=n; i++){
            wt[i]=sc.nextInt();
            pr[i]=sc.nextInt();
        }

        int dp[][]=new int[n+1][cp +1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i],-1);
        }
        int dp1[][]=new int[n+1][cp+1];

        System.out.println(solve(n,cp,wt,pr,dp));
        System.out.println(solve1(cp,wt,pr,dp1));
        sc.close();
    }
}
