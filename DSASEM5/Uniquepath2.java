import java.util.Arrays;
import java.util.Scanner;
class Uniquepath2 {
    static int solve(int grid[][], int dp[][], int m, int n){
       // base case
        if(m<0 || n<0) return 0;
        if(m==0 && n==0) return 1;
        
        if(grid[m][n]==1) return 0;
        
        // check dp alredy clculate value or not
        if(dp[m][n]!=-1){
            return dp[m][n];
        }

        int up=solve(grid,dp, m-1, n);
        int left=solve(grid,dp,m,n-1);

        return dp[m][n]=up+left;
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        // row
        int m=obstacleGrid.length;
        // colone
        int n=obstacleGrid[0].length;
        
        // create dp size m*n
        int dp[][]=new int[m][n];

        // fill dp -1
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(obstacleGrid,dp,m-1,n-1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int arr[][]=new int[m][n];
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(uniquePathsWithObstacles(arr)); 
    }
}