class Solution {
    public int maximumWealth(int[][] accounts) {
        int rich = 0;
        for (int[] i : accounts) {
            int sum = 0;
            for (int m : i) {
                sum += m;
            }
            rich = Math.max(rich, sum);
        }
        return rich;
    }
}