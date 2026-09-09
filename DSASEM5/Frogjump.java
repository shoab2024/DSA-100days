// leetcode 403
import java.util.Arrays;
import java.util.HashMap;
// leetcode 403
class Frogjump {
    static HashMap<Integer, Integer> mp=new HashMap<>();
    static boolean solve(int curr_stone_idx, int prevjump, int[] stones,int[][] dp){
        int n=stones.length;
        if(curr_stone_idx==n-1) return true;
        if(dp[curr_stone_idx][prevjump]!=-1) {
            return dp[curr_stone_idx][prevjump]==1;
        }
        
        boolean result=false;

        for(int nextjump=prevjump-1; nextjump<=prevjump+1;nextjump++){
            if(nextjump>0){
                int next_stone=stones[curr_stone_idx]+nextjump;
                if(mp.containsKey(next_stone)){
                    result=result || solve(mp.get(next_stone), nextjump,stones,dp);
                }
            }
        }
        dp[curr_stone_idx][prevjump] =(result ? 1:0);
        return result;
    }
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if(n<2 || stones[1] != 1){
            return false;
        }
        mp.clear();
        for(int i=0; i<n; i++){
            mp.put(stones[i],i);
        }
        int dp[][]=new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,stones,dp);
    }
}