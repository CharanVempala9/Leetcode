class Solution {
    public boolean isOneBitCharacter(int[] arr) {
        int n=arr.length;
        int i=1;
        if(n==1 && arr[0]==0)return true;
        int last=0;
        while(i<n){
            if(arr[i-1]==1 && arr[i]==1){
                last=i;
                i+=2;
            }
            else if(arr[i-1]==1 && arr[i]==0){
                last=i;
                i+=2;
            }
            else{
                i++;
            }
        }
        System.out.println(last);
        return last<=n-2;
    }
}