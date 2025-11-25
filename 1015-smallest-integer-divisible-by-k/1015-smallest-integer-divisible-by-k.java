class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0) return -1;
        int idx=0;
        int rem=0;
        while(idx<1000000){
            rem =( rem * 10 + 1 ) %k;
            if(rem==0){
                return idx+1;
            }
            idx++;
        }
        return -1;
    }
}

/*  he is giving k--->  10^5
    100000   1 11 111 1111  11111  111111   1111111  111111111


*/