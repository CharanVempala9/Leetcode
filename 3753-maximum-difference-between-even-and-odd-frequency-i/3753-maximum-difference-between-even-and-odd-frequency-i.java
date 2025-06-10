class Solution {
    public int maxDifference(String s) {
        int[] arr=new int[26];
        int n=s.length();
        for(int i=0; i<n; i++){
            arr[s.charAt(i)-'a']++;
        }
        int minEven=Integer.MAX_VALUE;
        int maxEven=Integer.MIN_VALUE;
        int minOdd=Integer.MAX_VALUE;
        int maxOdd=Integer.MIN_VALUE;
        for(int i=0; i<26; i++){
            if(arr[i]!=0){
                if(arr[i]%2==0){
                    maxEven=Math.max(maxEven,arr[i]);
                    minEven=Math.min(minEven,arr[i]);
                }
                else{
                    maxOdd=Math.max(maxOdd,arr[i]);
                    minOdd=Math.min(minOdd,arr[i]);
                }
            }
        }
        int res=maxOdd-minEven;
        int res1=maxOdd-maxEven;
        int res2=minOdd-minEven;
        int res3=minOdd-maxEven;
        int ans=Math.max(res,res1);
        int ans2=Math.max(res2,res3);
        return Math.max(ans,ans2);
    }
}