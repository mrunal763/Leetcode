class Solution {
    public boolean rabinKarp(String text , String pattern){
        int n = text.length();
        int m = pattern.length();

        if(n<m) return false;
        int prime = 101;
        int base = 256;
        int hash =1;
        for(int i=0;i<m-1;i++){
            hash = (hash*base)%prime;
        }
        int pHash=0;
        int tHash=0;
        for(int i=0;i<m;i++){
            pHash = (pHash* base + pattern.charAt(i))%prime;
            tHash = (tHash*base + text.charAt(i))%prime;
        }

        for(int i=0;i<=n-m;i++){
            if(pHash==tHash && text.substring(i,i+m).equals(pattern)){
                return true;
            }
            if(i<n-m){
                tHash = (base*(tHash-hash*text.charAt(i)) + text.charAt(i+m))%prime;
                if(tHash<0) tHash+=prime;
            }
        }
        return false;
    }
    public int repeatedStringMatch(String a, String b) {
        int max = (int)Math.ceil((double)b.length() / a.length()) + 1;
        for(int i=1;i<=max;i++){
            if(rabinKarp(a.repeat(i),b)){
                return i;
            }
        }
        return -1;
    }
}