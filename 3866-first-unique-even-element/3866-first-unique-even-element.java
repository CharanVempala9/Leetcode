class Solution {
    public int firstUniqueEven(int[] nums) {
        int n=nums.length;
        /*for(int i=0; i<n; i++){
            if(nums[i]%2==0){
                boolean fnd=false;
                int val=nums[i];
                for(int j=i+1; j<n; j++){
                    if(nums[j]==val){
                        fnd=true;
                    }
                }
                if(!fnd){
                    return val;
                }
            }
        }
        return -1;*/
        int[] arr=new int[101];
        for(int i=0; i<n; i++){
            arr[nums[i]]++;
        }
        for(int i=0; i<n; i++){
            if(nums[i]%2==0 && arr[nums[i]]==1)return nums[i];
        }
        return -1;
    }
}