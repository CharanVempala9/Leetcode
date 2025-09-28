class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=0;
        for(int i=0; i<n-2; i++){
            int a=nums[i];
            int b=nums[i+1];
            int c=nums[i+2];
            //System.out.print(a+" "+b+" "+c+" ");
            if(a+b>c && b+c>a && c+a>b){
                max=Math.max(max,a+b+c);
            }
        }
        return max;
    }
}