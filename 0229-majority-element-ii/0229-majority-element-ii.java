class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0,cnt2=0;
        int n=nums.length;
        int mini=n/3+1;
        List<Integer> ans=new ArrayList<>();
        int el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1==0 && el2!=nums[i]){
                cnt1=1;
                el1=nums[i];
            }else if(cnt2==0 && el1!=nums[i]){
                cnt2=1;
                el2=nums[i];
            }else if(el1==nums[i]){
                cnt1++;
            }else if(el2==nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;cnt2=0;
        for(int num:nums){
            if(el1==num){
                cnt1++;
            }
            if(el2==num){
                cnt2++;
            }
        }
        if(cnt1>=mini){
            ans.add(el1);
        }
        if(cnt2>=mini && el1!=el2){
            ans.add(el2);
        }
        return ans;
    }
}