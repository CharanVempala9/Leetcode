class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int h=height.length-1;
        int ans=0;
        while(l<h){
            int temp=(h-l) * Math.min(height[l],height[h]);
            //System.out.println(h+" "+l+" "+temp);
            ans=Math.max(ans,temp);
            if(height[l]<=height[h]){
                l++;
            }
            else{
                h--;
            }
        }
        return ans;
    }
}