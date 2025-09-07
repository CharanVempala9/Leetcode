class Solution {
    public int[] sumZero(int n) {
        int temp=n/2;
        int[] res=new int[n];
        if(n%2==0){
            for(int i=0; i<n/2; i++){
                res[i] = -temp;
                temp--;
            }
            temp=1;
            for(int i=n/2; i<n; i++){
                res[i] = temp;
                temp++;
            }
        }
        else{
            for(int i=0; i<n/2; i++){
                res[i] = -temp;
                temp--;
            }
            res[n/2]=0;
            temp=1;
            for(int i=(n/2)+1; i<n; i++){
                res[i] = temp;
                temp++;
            }
        }
        return res;
    }
} 