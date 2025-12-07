class Solution {
    public int countOdds(int low, int high) {
        if(low==high && low%2==0) return 0;
        if(low==high && low%2==1) return 1;
        if(low%2==1){
            int diff=high-low-1;
            int rem=diff/2;
            if(high%2==1){
                return rem+2;
            }
            else{
                return rem+1;
            }
        }
        else{
            int diff=high-low-1;
            int rem=diff/2;
            return rem+1;
        }
    }
}

/*  4 5 6 7 8     14 15 16 17 18  

    8 9 10 


    8 9 



*/