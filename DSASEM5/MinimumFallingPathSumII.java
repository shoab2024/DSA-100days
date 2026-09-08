import java.util.Arrays;

class MinimumFallingPathSumII {
    public int solve(int i,int j,int grid[][],int dp[][]){
        int n=grid.length;
        if(i==0) return grid[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int col=0;col<n;col++){
            if(j!=col){
                int path=grid[i][j]+solve(i-1,col,grid,dp);
                ans=Math.min(ans,path);
            }
        }
        return dp[i][j]=ans;
    }
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,solve(n-1,i,grid,dp));
        }
        return ans;
    }
}