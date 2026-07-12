class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = 0, max = 0;

        for (int i = 0; i < mat.length; i++) {
            int ones = java.util.Arrays.stream(mat[i]).sum();

            if (ones > max) {
                max = ones;
                row = i;
            }
        }

        return new int[]{row, max};
    }
}