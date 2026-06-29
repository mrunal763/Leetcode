class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Use StringBuilder to build the result
        StringBuilder ans = new StringBuilder();
        
        // Sort the array to get the lexicographically smallest and largest strings
        Arrays.sort(strs);
        // First string (smallest in sorted order)
        String first = strs[0]; 
         // Last string (largest in sorted order)
        String last = strs[strs.length - 1];
        
        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // If characters don't match, return the current prefix
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            // Append the matching character to the result
            ans.append(first.charAt(i));
        }
        
        // Return the longest common prefix found
        return ans.toString();
    
    }
}