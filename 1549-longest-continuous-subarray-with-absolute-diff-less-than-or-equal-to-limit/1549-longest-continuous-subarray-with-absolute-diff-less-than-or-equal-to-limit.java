class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer>ts=new TreeMap<>();
        int l=0;
        int ans=0;
        int n=nums.length;
        for(int r=0; r<n; r++){
            ts.put(nums[r],ts.getOrDefault(nums[r],0)+1);
            int min=ts.firstKey();
            int max=ts.lastKey();
            while(Math.abs(max-min)>limit){
                ts.put(nums[l],ts.get(nums[l])-1);
                if(ts.get(nums[l])==0){
                    ts.remove(nums[l]);
                }
                max=ts.lastKey();
                min=ts.firstKey();
                l++;
            }
            if(Math.abs(max-max)<=limit){
                ans=Math.max(ans,r-l+1);
                //System.out.println(r+" "+l);
            }
        }
        return ans;
    }
}