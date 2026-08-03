class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return calc(nums, k) - calc(nums, k - 1);
    }

    private int calc(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int r = 0, l = 0, sum = 0;
        int cnt = 0;
        while (r < nums.length) {
            sum += (nums[r] % 2);
            while (sum > goal) {
                sum -= (nums[l] % 2);
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }
}
