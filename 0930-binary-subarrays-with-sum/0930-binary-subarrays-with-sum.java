class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return calc(nums, goal) - calc(nums, goal - 1);
    }

    private int calc(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int r = 0, l = 0, sum = 0;
        int cnt = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }
}
