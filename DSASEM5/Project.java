import java.util.Arrays;
import java.util.Scanner;

public class Project {

    

    static int solve1(int i, int proj[][], int dp[]){
        if(i<0) return 0;

        //
        if(dp[i]!=-1) return dp[i];

        int skip=0+solve(i-1,proj,dp);
        int select=proj[i][2];
        
        int j=findPreviois(i,proj);

        select=select+solve1(j,proj, dp);

        return dp[i]=Math.max(skip,select);

    }

    static int findPreviois(int i, int proj[][]){
        int low=0;
        int high=i-1;

        int ans=-1;
        while(low<=high){
            int mid=(high-low)/2 + low;

            if(proj[mid][1]<proj[i][0]){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    static int solve(int i, int proj[][], int dp[]){
        if(i<0) return 0;

        //
        if(dp[i]!=-1) return dp[i];
        int skip=0+solve(i-1,proj,dp);
        int select=proj[i][2];
        int j=i-1;
        while(j>=0 && proj[j][1]>=proj[i][0]){
            j--;
        }
        select=select+solve(j,proj,dp);
        return dp[i]=Math.max(skip,select);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter element size: ");
        int n=sc.nextInt();
        int arr[][]=new int[n][3];

       // System.out.println("Enter element: ");
        for(int i=0; i<n; i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
                arr[i][2]=sc.nextInt();
            
        }

        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        
        System.out.println(solve1(n-1,arr,dp));


    }
    
}
