class Solution {
    public char kthCharacter(int k) {
        StringBuilder res=new StringBuilder();
        res.append('a');
        int val=(int)(Math.log(k)/Math.log(2))+1;
        int temp=1;
        int idx=1;
        while(idx<=val){
            int j=0;
            for(int i=res.length(); i<(int)Math.pow(2,idx); i++){
                char ch=res.charAt(j);
                j++;
                res.append((char)('a' + (ch - 'a' + 1) % 26));
                temp++;
                if(temp==k){
                    return res.charAt(i);
                }
            }
            System.out.println(res.toString());
            idx++;
        }
        return 'a';
    }
}