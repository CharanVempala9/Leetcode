class Solution {
    public int minimumDeletions(String word, int k) {
        int n=word.length();
        int[] arr=new int[26];
        for(int i=0; i<n; i++){
            arr[word.charAt(i)-'a']++;
        }
        Arrays.sort(arr);
        int res=Integer.MAX_VALUE;
        int del=0;
        for(int i=0; i<26; i++){
            int temp=arr[i];
            int ans=del;
            for(int j=25; j>i; j--){
                if(arr[j]-arr[i]<=k){
                    break;
                }
                ans+=arr[j]-temp-k;
            }
            res=Math.min(res,ans);
            del+=temp;
        }
        return res;
    }
}