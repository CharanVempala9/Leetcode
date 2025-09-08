class Solution {
    public boolean isposs(int n1,int n2){
        while(n1>0){
            int rem=n1%10;
            if(rem==0) return false;
            n1=n1/10;
        }
        while(n2>0){
            int rem=n2%10;
            if(rem==0) return false;
            n2=n2/10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        int[] res=new int[2];
        for(int i=1; i<=n; i++){
            int val=n-i;
            if(isposs(val,i)){
                res[0]=i;
                res[1]=n-i;
                break;
            }
        }
        return res;
    }
}