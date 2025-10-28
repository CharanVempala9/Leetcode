class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int cnt=0;
        // for(int i=0; i<n; i++){
        //     if(nums[i]==0){
        //         int bsum=0;
        //         for(int j=0; j<i; j++){
        //             bsum+=nums[j];
        //         }
        //         int asum=0;
        //         for(int j=i+1; j<n; j++){
        //             asum+=nums[j];
        //         }
        //         //System.out.print(bsum+" "+asum);
        //         if(bsum==asum){
        //             cnt+=2;
        //         }
        //         else if(bsum==asum-1 || asum==bsum-1){
        //             cnt++;
        //         }
        //     }
        // }
        int[] pf=new int[n];
        int[] sf=new int[n];
        pf[0]=nums[0];
        sf[n-1]=nums[n-1];
        for(int i=1; i<n; i++)pf[i]=pf[i-1]+nums[i];
        for(int i=n-2; i>=0; i--)sf[i]=sf[i+1]+nums[i];
        for(int i=0; i<n; i++){
            if(nums[i]==0 && pf[i]==sf[i])cnt+=2;
            else if(nums[i]==0 && (pf[i]==sf[i]-1 || sf[i]==pf[i]-1))cnt++;
        }
        return cnt;
    }
}


//   1 1 3 3 6
//   6 5 5 3 3


// 16 13 10  0  0  0 10  6 7  8  7
// 16 29 39 39 39 39 49 55 62 70 77
// 77 61 48 38 38 38 38 28 22 15  7


/*
    2 3  4 0  4  1  0
    2 5  9 9 13 14 14
   14 12 9 5  5  1  0

    1,0,2,0,0
    1 1 3 3 3 
    3 2 2 0 0
*/