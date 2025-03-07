class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] primes=new boolean[right+1];
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i=2; i*i<=right; i++){
            if(primes[i]){
                for(int j=i*i; j<=right; j+=i){
                    primes[j]=false;
                }
            }
        }
        ArrayList<Integer>ls=new ArrayList<>();
        for(int i=left; i<=right; i++){
            if(primes[i]){
                ls.add(i);
            }
        }
        if(ls.size()<2){
            return new int[]{-1,-1};
        }
        int[] res=new int[2];
        int ans=Integer.MAX_VALUE;
        for(int i=1; i<ls.size(); i++){
            int temp=Math.abs(ls.get(i-1)-ls.get(i));
            if(temp<ans){
                ans=temp;
                res[0]=ls.get(i-1);
                res[1]=ls.get(i);
            }
        }
        return res;
    }
}