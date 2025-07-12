class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int max=0;
        for(int num:hs){
            if(!hs.contains(num-1)){
                int val=num;
                int cnt=1;
                while(hs.contains(val+1)){
                    val++;
                    cnt++;
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
    }
}