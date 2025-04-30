class Solution {
    public boolean poss(int i){
        String res=String.valueOf(i);
        return (res.length()%2==0);
    }
    public int findNumbers(int[] nums) {
        int cnt=0;
        for(int num:nums){
            if(poss(num))
            cnt++;
        }
        return cnt;
    }
}