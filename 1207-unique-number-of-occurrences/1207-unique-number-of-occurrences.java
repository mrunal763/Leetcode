class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>();
        // store integer and count
        for(int x : arr){
            map.put(x , map.getOrDefault(x, 0)+1);
        }

        HashSet<Integer > set = new HashSet<>();
        
        // iterate over the hashset and check if the duplicate count exists or not
        for(int x: map.values()){
            if(set.contains(x)){
                return false;
            }else{
                set.add(x);
            }
        }
        return true;
    }
}