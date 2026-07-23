class Solution {
    private int[] computeLPS(String s) {
        int n = s.length(); // size of string

        // To store the longest prefix suffix
        int[] LPS = new int[n];

        int i = 1, j = 0;

        // Iterate on the string
        while (i < n) {
            // If the character matches
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i] = j + 1;
                i++;
                j++;
            }

            // Otherwise
            else {
                // Trace back j pointer till it does not match
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = LPS[j - 1];
                }

                // If a match is found
                if (s.charAt(i) == s.charAt(j)) {
                    LPS[i] = j + 1;
                    j++;
                }
                i += 1;
            }
        }

        return LPS; // Return the computed LPS array
    }

    public int strStr(String haystack, String needle) {
        String s = needle + '$' + haystack; // Combined string

        // Function call to find the LPS array for the combined string
        int[] LPS = computeLPS(s);

        int n = haystack.length(), m = needle.length();

        List<Integer> ans = new ArrayList<>();

        for (int i = m + 1; i < s.length(); i++) {
            if (LPS[i] == m)
                return (i - 2 * m);
        }

        return -1;
    }
}