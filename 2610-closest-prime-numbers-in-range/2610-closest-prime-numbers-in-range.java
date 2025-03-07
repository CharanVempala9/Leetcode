class Solution {
    public boolean isprime(int n) {
    if (n <= 1) return false;  
    if (n == 2 || n == 3) return true;  
    if (n % 2 == 0 || n % 3 == 0) return false;  
    for (int i = 5; i * i <= n; i += 6) {  
        if (n % i == 0 || n % (i + 2) == 0)  
            return false;  
        }
    return true;
}

    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer>ls=new ArrayList<>();
        for(int i=left; i<=right; i++){
            if(isprime(i)){
                ls.add(i);
            }
        }
        int[] res=new int[2];
        int ans=Integer.MAX_VALUE;
        if(ls.size()<2){
            return new int[]{-1,-1};
        }
        for(int i=1; i<ls.size(); i++){
                int temp=Math.abs(ls.get(i)-ls.get(i-1));
                if(temp<ans){
                    ans=temp;
                    res[0]=ls.get(i-1);
                    res[1]=ls.get(i);
                }
        }
        return res;
    }
}