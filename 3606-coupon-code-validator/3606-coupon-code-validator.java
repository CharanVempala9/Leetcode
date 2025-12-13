class Pair{
    String c;
    String b;
    public Pair(String c,String b){
        this.c=c;
        this.b=b;
    }
}
class Solution {
    public boolean can(String s){
        int n=s.length();
        if(s.equals(""))return false;
        for(int i=0; i<n; i++){
            int ch=s.charAt(i)-0;
            if((ch>=48 && ch<=57)  || (ch>=65 && ch<=90) || (ch>=97 && ch<=122) || (ch==95)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Pair>ls=new ArrayList<>();
        int n=code.length;
        for(int i=0; i<n; i++){
            if(isActive[i]){
                String bss=businessLine[i];
                if(bss.equals("electronics") || bss.equals("grocery") || bss.equals("pharmacy") || bss.equals("restaurant")){
                    String cd=code[i];
                    if(can(cd)){
                        ls.add(new Pair(cd,bss));
                    }
                }
            }
        }
        ls.sort((x, y) -> {
    int cmp = x.b.compareTo(y.b);
    if (cmp != 0) return cmp;
    return x.c.compareTo(y.c);
});

        List<String>ans=new ArrayList<>();
        for(int i=0; i<ls.size(); i++){
            Pair p=ls.get(i);
            ans.add(p.c);
        }
        return ans;
        
    }
}