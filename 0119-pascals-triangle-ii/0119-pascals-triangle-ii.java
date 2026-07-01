class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        
        ans.add(1); // C(n, 0) = 1
        
        for (int i = 1; i <= rowIndex; i++) {
            long val = (long) ans.get(i - 1) * (rowIndex - i + 1) / i;
            ans.add((int) val);
        }
        
        return ans;
    }
}