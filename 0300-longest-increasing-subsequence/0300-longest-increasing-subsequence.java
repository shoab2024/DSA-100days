class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int maxi=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
                    dp[i]=dp[j]+1;
                }
                if(dp[i]>maxi){
                    maxi=dp[i];
                }
            }
        }
        return maxi;        
    }
}