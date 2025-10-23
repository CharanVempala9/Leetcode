class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder res=new StringBuilder(s);
        while(res.length()>2){
            StringBuilder temp=new StringBuilder();
            for(int i=1; i<res.length(); i++){
                int val=res.charAt(i)-'0';
                int sval=res.charAt(i-1)-'0';
                int ans=(val+sval)%10;
                char ch=(char)(ans+'0');
                temp.append(ch);
            }
            //System.out.println(temp.toString());
            res=temp;
        }
        if(res.charAt(0)!=res.charAt(1)){
            return false;
        }
        return true;
    }
}