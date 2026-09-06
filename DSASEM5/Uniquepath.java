import java.util.Arrays;
import java.util.Scanner;

class Uniquepath {
    static int solve(int i, int j, int dp[][]){
        // base case 
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        // dp case
        if(dp[i][j]!=-1) return dp[i][j];

        int up=solve(i-1,j,dp);
        int left=solve(i,j-1,dp);

        return dp[i][j]=up+left;
    }
    public static int uniquePaths(int m, int n) {

        // create dp
        int dp[][]=new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(m-1,n-1, dp);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        System.out.println(uniquePaths(m,n)); 
    }
}