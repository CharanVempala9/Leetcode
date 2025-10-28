class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0; i<n; i++){
            if(nums[i]==0){
                int bsum=0;
                for(int j=0; j<i; j++){
                    bsum+=nums[j];
                }
                int asum=0;
                for(int j=i+1; j<n; j++){
                    asum+=nums[j];
                }
                System.out.print(bsum+" "+asum);
                if(bsum==asum){
                    cnt+=2;
                }
                else if(bsum==asum-1 || asum==bsum-1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}