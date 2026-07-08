class Solution {
    public int countOdds(int low, int high) {
        int diff = high-low+1;
        int num = diff/2;
        if(low%2!=0 && high%2!=0) return num+1;
        return num;
    }
}