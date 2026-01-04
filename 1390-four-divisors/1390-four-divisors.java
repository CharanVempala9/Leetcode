class Solution {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    public int sumFourDivisors(int[] nums) {
        int totsum=0;
        for(int n:nums){
            int cnt=0;
            int sum=0;
            if(isPrime(n)){
                continue;
            }
            for(int i=2; i<n; i++){
                if(n%i==0){
                    cnt++;
                    sum+=i;
                    if(cnt>2){
                        break;
                    }
                }
            }
            if(cnt==2){
                totsum+=sum+1+n;
            }
        }
        return totsum;
    }
}