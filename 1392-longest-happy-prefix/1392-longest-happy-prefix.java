class Solution {
    public String longestPrefix(String s) {
         int n = s.length(); 
        int[] LPS = new int[n];

        int i = 1, j = 0;

        while(i < n) {
            if(s.charAt(i) == s.charAt(j)) {
                LPS[i] = j+1;
                i++; j++;
            }
            else {
                
                while(j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = LPS[j-1];
                }

                if(s.charAt(i) == s.charAt(j)) {
                    LPS[i] = j+1;
                    j++;
                }
                i += 1;
            }
        }

        return s.substring(0, LPS[s.length() - 1]);
    }
}