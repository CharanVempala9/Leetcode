class Solution {
    public int binaryGap(int n) {
        int max=0;
        for(int i=31; i>=0; i--){
            int num=(n>>i)&1;
            if(num==1){
                for(int j=i-1; j>=0; j--){
                    int anum=(n>>j)&1;
                    if(anum==num){
                        max=Math.max(max,i-j);
                        break;
                    }
                }
            }
        }
        return max;
    }
}