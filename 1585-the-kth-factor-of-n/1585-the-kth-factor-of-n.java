class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer>ls=new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n%i==0)
            ls.add(i);
        }
        if(k>ls.size()){
            return -1;
        }
        return ls.get(k-1);
    }
}