class Solution {
    public static void generate(List<String>ls,String p,int o,int c){
        if(o==0 && c==0){
            ls.add(p);
            return;
        }
        if(o>0){
            generate(ls,p+'(',o-1,c);
        }
        if(c>o){
            generate(ls,p+')',o,c-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ls=new ArrayList<>();
        generate(ls,"",n,n);
        return ls;
    }
}