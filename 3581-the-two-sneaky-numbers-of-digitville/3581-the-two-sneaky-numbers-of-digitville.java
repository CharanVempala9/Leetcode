class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq=new int[101];
        for(int n:nums){
            freq[n]++;
        }
        int[] res=new int[2];
        int idx=0;
        for(int i=0; i<=100; i++){
            if(freq[i]==2){
                res[idx++]=i;
            }
        }
        return res;
    }
}