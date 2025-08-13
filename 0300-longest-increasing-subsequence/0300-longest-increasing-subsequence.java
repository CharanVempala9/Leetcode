class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer>ls=new ArrayList<>();
        ls.add(nums[0]);
        int ans=1;
        for(int i=1; i<n; i++){
            if(nums[i] > ls.get(ls.size()-1)){
                ls.add(nums[i]);
                ans++;
            }
            else{
                int idx = Collections.binarySearch(ls, nums[i]);
                if(idx<0){
                    idx = -idx-1;
                }
                ls.set(idx,nums[i]);
            }
        }
        return ans;
    }
}