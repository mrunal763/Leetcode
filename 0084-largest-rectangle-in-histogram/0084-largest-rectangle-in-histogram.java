class Solution {

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }

        return ans;
    }

    private int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nse = findNSE(heights);
        int[] pse = findPSE(heights);

        int largestArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            largestArea = Math.max(largestArea, area);
        }

        return largestArea;
    }
}