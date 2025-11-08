class Solution {
    public int minimumOneBitOperations(int n) {
        int k=0;
        int ans=0;
        while((n>>k)>0){
            int bit=(n>>k)&1;
            if(bit==1){
                int op=(int)Math.pow(2,k+1)-1;
                ans=op-ans;
            }
            k++;
        }
        return ans;
    }
}

/*  1 -> 1 op 
    10 -> 3 op 
    11 -> 2 op
    100 -> 7 op    ->  101 -> 111 -> 110 --> 10 -> 11 -> 01 -> 00
    101 -> 6 op
    110 -> 4 op
    111 -> 110 -> 10 -> 5 op 


    0-0
    1-1

    ///
    2-3   --  
    3-2       
    4-7       
    5-6       
    6-4       
    7-5       
    8-15
    9-14
    10-12
    11-13

    dp[i]=

*/