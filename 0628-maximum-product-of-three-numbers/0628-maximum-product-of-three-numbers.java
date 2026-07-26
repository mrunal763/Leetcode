class Solution {
    public int maximumProduct(int[] nums) {
        int first_max = Integer.MIN_VALUE, second_max = Integer.MIN_VALUE, third_max = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= first_max) {
                third_max = second_max;
                second_max = first_max;
                first_max = nums[i];
            } else if (nums[i] > second_max) {
                third_max = second_max;
                second_max = nums[i];

            } else if (nums[i] > third_max) {
                third_max = nums[i];
            }
            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] <= min2)
                min2 = nums[i];
        }
        return Math.max(first_max * second_max * third_max,
                min1 * min2 * first_max);
    }
}