class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        int len=nums[0].length();
        HashSet<String>hs=new HashSet<>();
        for(int i=0; i<n; i++){
            hs.add(nums[i]);
        }
        for(int i=0; i<Math.pow(2,len); i++){
            String res=Integer.toBinaryString(i);
            String ans = String.format("%" + len + "s", res).replace(' ', '0');
            if(!hs.contains(ans))
            return ans;
        }
        return "s";
    }
}