class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] res=new int[n];
        Arrays.fill(res,-1);
        for(int i=0; i<n; i++){
            int val=nums.get(i);
            for(int j=0; j<val; j++){
                if((j|j+1) == val ){
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }
}