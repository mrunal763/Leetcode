class Solution {
    public int singleNumber(int[] nums) {
      int result=0;
        int length=nums.length;
        int i=0;
        while(length>0){
            result^=nums[i];
            i++;
            length--;
        }
        return result;   
    }
}