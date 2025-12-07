class Solution {
    public int countOdds(int low, int high) {
        int cnt=0;
        if(low%2==1){
            for(int i=low; i<=high; i+=2){
                cnt++;
            }
        }
        else{
            for(int i=low+1; i<=high; i+=2){
                cnt++;
            }
        }
        return cnt;
    }
}

/* 3  4 5 6 7 

    8 9 10 


    8 9 



*/