class Solution {
    public int maxFrequencyElements(int[] nums) {
     int n = nums.length;
        
      
        int maxFreq = 0; 
       
        int res = 0;
        
       
        Map<Integer, Integer> mpp = new HashMap<>();
        
      
        for (int i = 0; i < n; i++) {
           
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }
      
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
    
            int freq = it.getValue(); // Value
            
            if (freq > maxFreq) {
                maxFreq = freq;
                res = freq;
            } else if (freq == maxFreq) {
                res +=freq ;
            }
        }
        
      
        return res;
    }
}


