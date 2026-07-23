class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeatedA = new StringBuilder(a);
        int count = 1;

        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            count++;
        }

        if (repeatedA.indexOf(b) != -1)
            return count;

        repeatedA.append(a);
        count++;

        if (repeatedA.indexOf(b) != -1)
            return count;

        return -1;
    }
}