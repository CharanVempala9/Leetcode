class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        int n=nums.length;
        for(int i=0; i<n; i++){
            hs.add(nums[i]);
        }
        int l=0;
        int ans=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int r=0; r<n; r++){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(hm.size()==hs.size()){
                ans+=n-r;
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0)
                hm.remove(nums[l]);
                l++;
            }
        }
        return ans;
        
    }
}