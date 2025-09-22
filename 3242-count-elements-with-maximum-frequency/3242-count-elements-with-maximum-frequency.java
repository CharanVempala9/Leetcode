class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr=new int[101];
        int max=0;
        for(int n:nums){
            arr[n]++;
            max=Math.max(max,arr[n]);
        }
        int cnt=0;
        for(int i=1; i<101; i++){
            if(arr[i]==max)cnt+=max;
        }
        return cnt;
    }
}