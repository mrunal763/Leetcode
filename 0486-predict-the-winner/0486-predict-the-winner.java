class Solution {

    public boolean predictTheWinner(int[] nums) {
        
        int n = nums.length;
        int[] dp = nums.clone(); 
        
        for (int diff = 1; diff < n; ++diff) {
            for (int j = n - 1; j - diff >= 0; --j) {
                int i = j - diff;
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        
        return dp[n - 1] >= 0;
    }
}