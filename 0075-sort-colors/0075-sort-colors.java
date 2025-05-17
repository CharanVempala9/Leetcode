class Solution {
    public void sortColors(int[] nums) {
        int zcnt=0;
        int ocnt=0;
        int tcnt=0;
        for(int num:nums){
            if(num==0)
            zcnt++;
            else if(num==1)
            ocnt++;
            else
            tcnt++;
        }
        for(int i=0; i<zcnt; i++){
            nums[i]=0;
        }
        for(int i=0; i<ocnt; i++){
            nums[i+zcnt]=1;
        }
        for(int i=0; i<tcnt; i++){
            nums[i+zcnt+ocnt]=2;
        }
    }
}