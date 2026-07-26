class Solution {
    public int maximumProduct(int[] nums) {
        int smallest1 = Integer.MAX_VALUE, smallest2 = Integer.MAX_VALUE;
        int largest1 = Integer.MIN_VALUE, largest2 = Integer.MIN_VALUE, largest3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < smallest2) {
                if (num < smallest1) {
                    smallest2 = smallest1;
                    smallest1 = num;
                } else {
                    smallest2 = num;
                }
            }

            if (num > largest3) {
                if (num > largest1) {
                    largest3 = largest2;
                    largest2 = largest1;
                    largest1 = num;
                } else if (num > largest2) {
                    largest3 = largest2;
                    largest2 = num;
                } else {
                    largest3 = num;
                }
            }
        }

        int withSmallest = smallest1 * smallest2 * largest1;
        int largestOnly = largest1 * largest2 * largest3;

        return withSmallest > largestOnly ? withSmallest : largestOnly;
    }
}