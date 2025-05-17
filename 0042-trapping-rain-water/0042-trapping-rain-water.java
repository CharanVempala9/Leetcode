class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int leftmax=height[0];
        int rightmax=height[n-1];
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=height[0];
        right[n-1]=height[n-1];
        for(int i=1; i<n; i++){
            leftmax=Math.max(height[i],leftmax);
            left[i]=leftmax;
        }
        for(int i=n-2; i>=0; i--){
            rightmax=Math.max(height[i],rightmax);
            right[i]=rightmax;
        }
        int ans=0;
        for(int i=0; i<n; i++){
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}