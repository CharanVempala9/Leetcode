class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        ArrayList<Integer>lsthan=new ArrayList<>();
        ArrayList<Integer>gtthan=new ArrayList<>();
        ArrayList<Integer>eq=new ArrayList<>();
        for(int i=0;i<n; i++){
            if(nums[i]<pivot)
            lsthan.add(nums[i]);
            else if(nums[i]>pivot)
            gtthan.add(nums[i]);
            else
            eq.add(nums[i]);
        }
        int size1=lsthan.size();
        int size2=gtthan.size();
        int size3=eq.size();
        int idx=0;
        int cnt=0;
        while(idx<size1){
            nums[idx]=lsthan.get(idx);
            idx++;
        }
        int idx2=0;
        while(idx2<size3){
            nums[idx]=eq.get(idx2);
            idx++;
            idx2++;
        }
        int idx3=0;
        while(idx<n){
            nums[idx]=gtthan.get(idx3);
            idx++;
            idx3++;
        }
        return nums;
    }
}