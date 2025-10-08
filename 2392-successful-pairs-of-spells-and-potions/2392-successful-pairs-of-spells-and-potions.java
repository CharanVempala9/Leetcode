class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int[] res=new int[n];
        Arrays.sort(potions);
        for(int i=0; i<n; i++){
            int l=0;
            int h=m-1;
            int ans=-1;
            while(l<=h){
                int mid=l+(h-l)/2;
                if((long)spells[i]*potions[mid]>=success){
                    ans=mid;
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            if(ans!=-1)
            res[i]=m-ans;
            else
            res[i]=0;
        }
        return res;
    }
}