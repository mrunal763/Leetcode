class Solution {

    private void func(int ind, int sum, List<Integer> nums,
            int[] candidates, List<List<Integer>> ans) {
        if (sum == 0) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        if (sum < 0 || ind == candidates.length)
            return;

        nums.add(candidates[ind]);

        func(ind + 1, sum - candidates[ind], nums, candidates, ans);

        nums.remove(nums.size() - 1);

        for (int i = ind + 1; i < candidates.length; i++) {
            if (candidates[i] != candidates[ind]) {
                func(i, sum, nums, candidates, ans);
                break;
            }
        }
    }

    public void quickSort(int from, int to, int[] arr) {
        if (from >= to)
            return;
        int pivot = arr[to];
        int pt = from;
        for (int i = from; i < to; i++) {
            if (arr[i] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[pt];
                arr[pt] = tmp;
                pt++;
            }
        }
        int tmp = arr[to];
        arr[to] = arr[pt];
        arr[pt] = tmp;
        quickSort(from, pt - 1, arr);
        quickSort(pt + 1, to, arr);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        quickSort(0, candidates.length - 1, candidates);

        func(0, target, nums, candidates, ans);
        return ans;
    }
}