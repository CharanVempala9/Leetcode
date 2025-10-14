class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        boolean found=false;
        int cnt=1;
        if(k==1 && n>=2) return true;
        for(int i=1; i<n; i++){
            if(nums.get(i-1)<nums.get(i)){
                cnt++;
                if(cnt>=k){
                    int nxtcnt=1;
                    int temp=k;
                    int j=i+1;
                    //System.out.println("entered");
                    //System.out.println(i);
                    while(temp-->0 && i+k<n){
                        if(nums.get(j)<nums.get(j+1)){
                            //System.out.println(nums.get(j)+" "+nums.get(j+1));
                            nxtcnt++;
                            j++;
                            if(nxtcnt==k) return true;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            else{
                cnt=1;
            }
        }
        return false;
    }
}