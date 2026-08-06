class Solution {
    public int smallestNumber(int n, int t) {
       
       for(int i=n;i<n+10;i++){
        if(digitProduct(i)%t==0){
            return i;
        }
       }return 0;
    }
    private static int digitProduct(int a){
        int product=1;
        while(a>0){
            int last=a%10;
            product*=last;
            a=a/10;
        }
        return product;
    }
}