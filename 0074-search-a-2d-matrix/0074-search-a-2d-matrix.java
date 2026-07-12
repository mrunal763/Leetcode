class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length; 
        int low = 0, high = n - 1;
        while (low <= high) {
        
            int mid = (low + high) / 2;

         
            if (nums[mid] == target) 
                return true; 
            else if (target > nums[mid]) 
                low = mid + 1; 
            else 
                high = mid - 1; 
        }
        return false; 
    }
    public boolean searchMatrix(int[][] mat, int target) {
         int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) 
            if(search(mat[i],target))
                return true;
        return false;   
    }
}
