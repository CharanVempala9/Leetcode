class Solution {
    public int longestBalanced(int[] nums) {
        int ans=0;
        int n=nums.length;
        int max=0;
        for(int i=0; i<n; i++){
            HashSet<Integer>ev=new HashSet<>();
            HashSet<Integer>od=new HashSet<>();
            if(nums[i]%2==1)od.add(nums[i]);
            else ev.add(nums[i]);
            for(int j=i+1; j<n; j++){
                if(nums[j]%2==1)od.add(nums[j]);
                else ev.add(nums[j]);
                if(od.size()==ev.size()){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}