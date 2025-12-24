class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int n=capacity.length;
        int sum=0;
        for(int a:apple){
            sum+=a;
        }
        int cnt=0;
        for(int i=n-1; i>=0; i--){
            sum-=capacity[i];
            cnt++;
            if(sum<=0){
                break;
            }
        }
        return cnt;
    }
}