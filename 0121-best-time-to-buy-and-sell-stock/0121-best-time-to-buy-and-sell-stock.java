class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
         int maxProfit = 0;
        int mini = prices[0]; 
        for (int i = 1; i < n; i++) {

            int curProfit = prices[i] - mini; 
            maxProfit = Math.max(maxProfit, curProfit); 
            mini = Math.min(mini, prices[i]); 
        }
      
        return maxProfit; 
    }
}