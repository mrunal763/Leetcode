class Solution {
    public void func(List<Integer> v, int i, int sum,
            List<Integer> curr,
            List<List<Integer>> ans) {

        if (sum == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (i >= v.size() || sum < 0) {
            return;
        }

        curr.add(v.get(i));
        func(v, i, sum - v.get(i), curr, ans);

        curr.remove(curr.size() - 1);

        func(v, i + 1, sum, curr, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        for (int num : candidates) {
            v.add(num);
        }

        // Start the recursive process
        func(v, 0, target, new ArrayList<>(), ans);

        return ans;
    }
};
