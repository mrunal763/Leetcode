class Solution {
    public void reverseString(char[] s) {
        int st=0;int e=s.length-1;
        while(st<e){
            char t=s[st];
            s[st]=s[e];
            s[e]=t;
            st++;
            e--;
        }
    }
}