class Solution {
    public int findLucky(int[] arr) {
        int[] num=new int[501];
        int n=arr.length;
        for(int i=0; i<n; i++){
            num[arr[i]]++;
        }
        for(int i=arr.length; i>0; i--){
            if(i==num[i]){
                return i;
            }
        }
        return -1;
    }
}