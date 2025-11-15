class Solution {
    public int checkbit(int n,int i){
        return (n>>i)&1;
    }
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int temp = checkbit(left,i);
            int temp2 = checkbit(right,i);
            if (temp == temp2 && temp == 1) {
                ans |= (1 << i);
            } else if (temp != temp2) {
                break;
            }
        }
        return ans;
    }
}
