class Solution {
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public int lcm(int hcf,int a,int b){
        return (a/hcf)*b;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer>ls=new ArrayList<>();
        for(int n:nums){
            ls.add(n);
        }
        int l = 1;
        while (l < ls.size()) {
            int hcf = gcd(ls.get(l - 1), ls.get(l));
            if (hcf > 1) {
                int newVal = lcm(hcf,ls.get(l - 1), ls.get(l));
                ls.set(l, newVal); 
                ls.remove(l - 1); 
                l = Math.max(1, l - 1);
            }else {
                l++;
            }
        }
        return ls;
    }
}