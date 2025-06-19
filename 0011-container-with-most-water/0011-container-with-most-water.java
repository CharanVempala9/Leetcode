class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int max=Integer.MIN_VALUE;
        int min=0;
        while(l<r){
            min=Math.min(height[l],height[r]);
            int diff=min*(r-l);
            max=Math.max(diff,max);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
    }

}