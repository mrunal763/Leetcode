class Solution {

    private void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        if (index == n) {
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(index + 1, n, nums, current, ans);

        current.remove(current.size() - 1);
        backtrack(index + 1, n, nums, current, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, nums.length, nums, current, ans);
        return ans;
    }
}