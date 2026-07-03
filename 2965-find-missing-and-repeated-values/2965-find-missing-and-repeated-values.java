class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        long N = (long) grid.length * grid.length;

        // Expected sum
        long SN = (N * (N + 1)) / 2;

        // Expected sum of squares
        long S2N = (N * (N + 1) * (2 * N + 1)) / 6;

        long S = 0;
        long S2 = 0;

        // Calculate actual sum and square sum
        for (int[] row : grid) {
            for (int num : row) {
                S += num;
                S2 += (long) num * num;
            }
        }

        // x - y
        long val1 = S - SN;

        // x² - y²
        long val2 = S2 - S2N;

        // x + y
        val2 = val2 / val1;

        // Repeating number (x)
        long x = (val1 + val2) / 2;

        // Missing number (y)
        long y = x - val1;

        return new int[]{(int) x, (int) y};
    }
}