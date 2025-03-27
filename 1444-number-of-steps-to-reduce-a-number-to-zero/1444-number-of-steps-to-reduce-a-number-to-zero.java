class Solution {
    public int reduces(int num, int cnt){
        if(num==0)
        return cnt;
        if(num%2==0){
            return reduces(num/2, cnt+1);
        }
        return reduces(num-1, cnt+1);
    }
    public int numberOfSteps(int num) {
        int ans=reduces(num,0);
        return ans;
    }
}