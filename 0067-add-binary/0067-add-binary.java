class Solution {
    public String addBinary(String a, String b) {
        int i1=a.length()-1;
        int i2=b.length()-1;
        StringBuilder res=new StringBuilder();
        int carry=0;
        while(i1>=0 && i2>=0){
            if(a.charAt(i1)=='1' && b.charAt(i2)=='1'){
                if(carry==1){
                    res.append('1');
                }
                else{
                    res.append('0');
                }
                carry=1;
            }
            else if(a.charAt(i1)=='1' || b.charAt(i2)=='1'){
                if(carry==1){
                    res.append('0');
                    carry=1;
                }
                else{
                res.append('1');
                }
            }
            else{
                if(carry==1){
                    res.append('1');
                    carry=0;
                }
                else
                res.append('0');
            }
            i1--;
            i2--;
        }
        while(i1>=0){
            char ch=a.charAt(i1);
            if(ch=='1' && carry==1){
                res.append('0');
                carry=1;
            }
            else if(ch=='1' || carry==1){
                res.append('1');
                carry=0;
            }
            else{
                res.append('0');
            }
            i1--;
        }
        while(i2>=0){
            char ch=b.charAt(i2);
            if(ch=='1' && carry==1){
                res.append('0');
                carry=1;
            }
            else if(ch=='1' || carry==1){
                res.append('1');
                carry=0;
            }
            else{
                res.append('0');
            }
            i2--;
        }
        if(carry==1){
            res.append('1');
        }
        return res.reverse().toString();
    }
}