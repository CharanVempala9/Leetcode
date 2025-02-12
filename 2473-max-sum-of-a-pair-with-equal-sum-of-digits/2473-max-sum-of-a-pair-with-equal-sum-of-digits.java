class Solution {
    public static int sum(int val){
        int ans=0;
        while(val>0){
            ans+=val%10;
            val/=10;
        }
        return ans;
        }
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int max=-1;
        for(int i=0; i<nums.length; i++){
            int val=sum(nums[i]);
            if(hm.containsKey(val)){
                max=Math.max(max,hm.get(val)+nums[i]);
                hm.put(val,Math.max(hm.get(val), nums[i]));
            }else{
                hm.put(val,nums[i]);
            }
        }
        return max;
    }
}