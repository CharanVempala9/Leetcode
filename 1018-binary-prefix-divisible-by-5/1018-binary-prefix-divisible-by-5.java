class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean>ls=new ArrayList<>();
        int n=nums.length;
        // int[] pfx=new int[n];
        // int idx=0;
        // pfx[0]=(int)Math.pow(2,idx)*nums[0];
        // idx++;
        // for(int i=1; i<n; i++){
        //     pfx[i]=pfx[i-1]+(int)Math.pow(2,idx)*nums[i];
        //     idx++;
        // }
        int val = 0;
        for (int i = 0; i < n; i++) {
            val = ((val << 1) + nums[i]) % 5;
            ls.add(val == 0);
        }
        return ls;
    }
}