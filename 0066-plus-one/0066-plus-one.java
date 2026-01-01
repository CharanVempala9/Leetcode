class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        ArrayList<Integer>ls=new ArrayList<>();
        int c=0;
        for(int i=n-1; i>=0; i--){
            int tmp=-1;
            if(i==n-1){
                tmp=digits[i]+1;
            }
            else{
                tmp=digits[i]+c;
            }
            if(tmp>9){
                ls.add(0);
                c=1;
            }
            else{
                ls.add(tmp);
                c=0;
            }
        }
        ls.add(c);
        int[] res=new int[n+c];
        for(int i=n+c-1; i>=0; i--){
            res[n+c-i-1]=ls.get(i);
        }
        return res;
    }
}