import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        int[] freq = new int[maxVal + 1];
        for (int x : nums) freq[x]++;

        long[] divisibleCount = new long[maxVal + 1];

        // Count how many numbers are divisible by d
        for (int d = 1; d <= maxVal; d++) {
            for (int multiple = d; multiple <= maxVal; multiple += d) {
                divisibleCount[d] += freq[multiple];
            }
        }

        long[] gcdExact = new long[maxVal + 1];

        // Inclusion-Exclusion:
        // gcdExact[d] = pairs with gcd exactly d
        for (int d = maxVal; d >= 1; d--) {
            long pairs = divisibleCount[d] * (divisibleCount[d] - 1) / 2;

            for (int multiple = d * 2; multiple <= maxVal; multiple += d) {
                pairs -= gcdExact[multiple];
            }

            gcdExact[d] = pairs;
        }

        // Prefix counts of sorted gcdPairs
        long[] prefix = new long[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            prefix[d] = prefix[d - 1] + gcdExact[d];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // convert 0-based index to 1-based position

            int left = 1, right = maxVal;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = left;
        }

        return answer;
    }
}