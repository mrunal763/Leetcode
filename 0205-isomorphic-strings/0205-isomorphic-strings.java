class Solution {
    public boolean isIsomorphic(String s, String t) {
          int[] m1 = new int[256], m2 = new int[256];
        
        // Length of the string
        int  n = s.length();
        
        // Iterate through each character in the strings
        for (int i = 0; i < n; ++i) {
            // If the last seen positions of the current characters don't match, return false
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            
            // Update the last seen positions
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        
        // If all characters match, return true
        return true;
    }
}