#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;
long long solve(int n, int val, vector<vector<int>> &nums, vector<vector<long long>> &dp)
{
    if (val == 0)
        return 0;
    if (n < 0)
        return INT_MAX;
    if (dp[n][val] != -1)
        return dp[n][val];
    long long pick = INT_MAX;
    if (nums[n][1] <= val)
    {
        pick = nums[n][0] + solve(n - 1, val - nums[n][1], nums, dp);
    }
    long long not_pick = solve(n - 1, val, nums, dp);
    return dp[n][val] = min(pick, not_pick);
}
int main()
{
    int n, weight;
    cin >> n >> weight;
    vector<vector<int>> nums(n, vector<int>(2));
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> nums[i][0] >> nums[i][1];
        sum += nums[i][1];
    }
    vector<vector<long long>> dp(n,vector<long long>(sum + 1, -1));
    long long ans = 0;
    for (int i = 0; i <= sum; i++)
    {
        long long f = solve(n - 1, i, nums, dp);
        if (f <= weight)
        {
            ans = i;
        }
    }
    cout << ans;
}