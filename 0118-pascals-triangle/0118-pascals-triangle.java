class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(pascalTriangle(i));
        }
        return ans;
    }
     private static List<Integer> pascalTriangle(int r) {
        List<Integer> ans=new ArrayList<>();
        ans.add(1); 
       
        for(int i = 1; i < r; i++) {
            long val= (long)(ans.get(i-1) * (r - i)) / i;
            ans.add((int)val);
        }
        
        return ans; 
    }
}