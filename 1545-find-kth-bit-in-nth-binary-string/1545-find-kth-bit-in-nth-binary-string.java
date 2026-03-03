class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder res=new StringBuilder();
        res.append('0');
        while(n-->0){
            //System.out.println(res.toString());
            StringBuilder tmp=new StringBuilder();
            int size=res.length()-1;
            for(int i=size; i>=0; i--){
                if(res.charAt(i)=='1')tmp.append('0');
                else tmp.append('1');
            }
            res.append('1');
            res.append(tmp);
        }
        //System.out.println(res.toString());
        return res.charAt(k-1);
    }
}