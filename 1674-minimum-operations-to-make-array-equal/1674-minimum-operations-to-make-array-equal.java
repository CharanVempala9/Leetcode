class Solution {
    public int minOperations(int n) {
        if(n%2==0){
            int res=0;
            int i=0;
            while(i<=n/2-1){
                res+=Math.abs((2*i+1)-n);
                i++;
            }
            return res;
            
        }
        else{
            int res=0;
            int i=0;
            while(i<=n/2){
                res+=Math.abs((2*i+1)-n);
                i++;
            }
            return res;
        }
    }
}