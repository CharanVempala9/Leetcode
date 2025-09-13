class Solution {
    public void nextPermutation(int[] nums) {
        int idx1=-1;
        int idx2=-1;
        //find the first dip
        int n=nums.length;
        for(int i=n-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                idx1=i;
                break;
            }
        }
        //System.out.println(idx1);
        if(idx1==-1){
            reverse(nums,0);
        }
        else{
            //find greater number in right half
            for(int i=n-1; i>=0; i--){
                if(nums[i]>nums[idx1]){
                    idx2=i;
                    break;
                }
            }
            swap(nums,idx1,idx2);
            reverse(nums,idx1+1);
        }
    }
    public void swap(int[] nums,int idx1,int idx2){
        int temp=nums[idx2];
        nums[idx2]=nums[idx1];
        nums[idx1]=temp;
    }
    public void reverse(int[] nums,int l){
        int r=nums.length-1;
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
}