import java.util.Arrays;
import java.util.Scanner;

class Knapsack01{
    static long dp[][]=new long[105][100005];

    static long solve(int cap, int wt[], int pr[],int idx){
        if(cap==0) return 0;
        if(idx<=0) return 0;
        //dp condition
        if(dp[idx][cap]!=-1) return dp[idx][cap];
        // skip
        long skip=solve(cap,wt,pr,idx-1);
        long select=Long.MIN_VALUE;
        if(cap>=wt[idx-1]){
            select=pr[idx-1]+solve(cap-wt[idx-1],wt,pr,idx-1);
        }
        return dp[idx][cap]=Math.max(skip,select);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cap=sc.nextInt();

        int wt[]=new int[n];
        int pr[]=new int[n];
        for(int i=0; i<n; i++){
            wt[i]=sc.nextInt();
            pr[i]=sc.nextInt();
        }
        for(int i=0; i<105; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(solve(cap,wt,pr,n));
        sc.close();

    }
}