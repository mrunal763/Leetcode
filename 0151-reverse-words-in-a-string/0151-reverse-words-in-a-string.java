class Solution {
    public String reverseWords(String s) {  
        char[] arr = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int end = arr.length-1;

        while(end >=0)
        {
            while(end >= 0 && arr[end] == ' ')
            {
                end--;
            }
            if(end < 0) break;
            
            int start = end ;
            while (start >=0 && arr[start] != ' '){
                start--;
            }

            if(result.length() > 0 ){
                result.append(' ');
            }

            result.append(arr,start+1,end-start);
            end = start;
        }

        return result.toString();
    }
}