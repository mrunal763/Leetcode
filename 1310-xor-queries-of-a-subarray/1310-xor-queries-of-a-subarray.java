class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int[] query:queries){
            int a=query[0];
            int b=query[1];
            int res=0;
            for(int i=a;i<=b;i++){
                res=res^arr[i];
            }
            ans.add(res);
        }

        int[] arr1 = ans.stream().mapToInt(Integer::intValue).toArray();
        return arr1;
    }
}