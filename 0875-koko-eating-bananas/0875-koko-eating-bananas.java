class Solution {
    private int findMax(int[] nums) {
        int maxi = Integer.MIN_VALUE;

        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }

        return maxi;
    }

    private long calculateTotalHours(int[] nums, int hourly) {
        long totalH = 0;

        for (int num : nums) {
            totalH += (long) Math.ceil((double) num / hourly);
        }

        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalH = calculateTotalHours(piles, mid);

            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}