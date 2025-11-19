class Solution {
    public int findFinalValue(int[] nums, int original) {
        //Arrays.sort(nums);
        int n=nums.length;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        while(hm.containsKey(original)){
            original*=2;
        }
        return original;
    }
}