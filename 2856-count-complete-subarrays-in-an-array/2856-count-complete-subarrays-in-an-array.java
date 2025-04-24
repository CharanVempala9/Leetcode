class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int l=0;
        int ans=0;
        for(int r=0; r<n; r++){
            HashMap<Integer,Integer>hm1=new HashMap<>();
            for(int i=r; i<n; i++){
                hm1.put(nums[i],hm.getOrDefault(nums[i],0)+1);
                if(hm1.size()==hm.size())
                ans++;
            }
        }
        return ans;
        
    }
}