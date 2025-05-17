class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int zcnt=0;
        int ocnt=0;
        int tcnt=0;
        for(int i=0; i<n; i++){
            if(nums[i]==0)
            zcnt++;
            else if(nums[i]==1)
            ocnt++;
            else
            tcnt++;
        }
        for(int i=0; i<zcnt; i++){
            nums[i]=0;
        }
        for(int i=0; i<ocnt; i++){
            nums[zcnt+i]=1;
        }
        for(int i=0; i<tcnt; i++){
            nums[zcnt+ocnt+i]=2;
        }
    }
}