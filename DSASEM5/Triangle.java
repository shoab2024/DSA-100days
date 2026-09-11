import java.util.ArrayList;
import java.util.List;

class Triangle {
    static int solve(List<List<Integer>> tri, int m, int n, List<List<Integer>> dp){
        
        // BASE CASE
        if(m==tri.size()-1) return tri.get(m).get(n);

        if(dp.get(m).get(n)!=-1) return dp.get(m).get(n);

        int op1=solve(tri,m+1, n,dp);
        int op2=solve(tri, m+1, n+1,dp);

        int ans=tri.get(m).get(n)+Math.min(op1,op2);
        dp.get(m).set(n, ans);
        return ans;
    }


    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp=new ArrayList<>();
        for(int i=0; i<triangle.size(); i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0; j< triangle.get(i).size(); j++){
                row.add(-1);
            }
            dp.add(row);
        }
        return solve(triangle,0,0, dp);


    //    int n=triangle.size();

    //    // create a dp
    //    int dp[]=new int[n];

    //    for(int j=0; j<n; j++){
    //     dp[j]=triangle.get(n-1).get(j);
    //    }

    //    //
    //    for(int i=n-2; i>=0; i--){
    //     for(int j=0; j<=i; j++){
    //         dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
    //     }
    //    }
    //    return dp[0];
    }
}