class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int indx=-1;
        int maxcount=-1;
        for(int i=0;i<mat.length;i++){
            int countrow=0;
            for(int j=0;j<mat[i].length;j++){
                countrow+=mat[i][j];
            }
            if(countrow>maxcount){
                maxcount=countrow;
                indx=i;
            }
        }
        int[] ans={indx,maxcount};
        return ans;
    }
}