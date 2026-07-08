class Solution {
    public boolean isAnagram(String s, String t) {
        // Edge Cases
        if (s.length() != t.length()) return false;

        // To store the count of each character
        int[] count = new int[26];

        // Count occurrence of each character in first string 
        for (char c : s.toCharArray()) count[c - 'a']++;

        // Decrement the count for each character in the second string
        for (char c : t.toCharArray()) count[c - 'a']--;

        // Check for count of every character
        for (int i : count) {
            // If the count is not zero
            if (i != 0) return false; // Return false
        }

        // Otherwise strings are anagram
        return true;
    }
}