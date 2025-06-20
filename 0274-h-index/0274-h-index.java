class Solution {
    public boolean isposs(int[] arr,int mid){
        int n=arr.length;
        int cnt=0;
        for(int i=0; i<n; i++){
            if(arr[i]>=mid){
                cnt++;
            }
        }
        return cnt>=mid;
    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int l=0;
        int h=citations.length;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isposs(citations,mid)){
                l=mid+1;
                ans=mid;
            }
            else{
                h=mid-1;
            }
        }
        return ans;
    }
}