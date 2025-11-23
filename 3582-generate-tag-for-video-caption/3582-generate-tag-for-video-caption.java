class Solution {
    public String generateTag(String cap) {
        String[] res=cap.split(" ");
        StringBuilder tmp=new StringBuilder();
        int tkn=-1;
        tmp.append('#');
        for(int i=0; i<res.length && tmp.length()<=100; i++){
            if(res[i].equals(" ") || res[i].length()==0)continue;
            char ch=res[i].charAt(0);
            if(tkn==-1){
                char upcase=Character.toLowerCase(ch);
                tmp.append(upcase);
                tkn=i;
            }
            else{
                char upcase=Character.toUpperCase(ch);
                tmp.append(upcase);
            }
            tmp.append(res[i].substring(1).toLowerCase());
        }
        //System.out.println(tmp.length());
        if(tmp.length()>=100){
            for(int i=tmp.length()-1; i>=100; i--){
                //System.out.println(i);
                tmp.deleteCharAt(i);
            }
        }
        //System.out.println(tmp.length());
        return tmp.toString();
    }
}