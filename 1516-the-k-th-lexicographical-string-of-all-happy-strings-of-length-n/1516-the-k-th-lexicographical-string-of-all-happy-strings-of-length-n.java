class Solution {
    public void happyString(int idx,String s,int n,ArrayList<String> l)
    {
        if(s.length()==n)
        {
            l.add(s);
            return;
        }

        if(s.length()==0||s.charAt(s.length()-1)!='a')
        happyString(idx+1,s+"a",n,l);
        
        if(s.length()==0||s.charAt(s.length()-1)!='b')
        happyString(idx+1,s+"b",n,l);

        if(s.length()==0||s.charAt(s.length()-1)!='c')
        happyString(idx+1,s+"c",n,l);

        return ;


    }
    public String getHappyString(int n, int k) {
        ArrayList<String> arr = new ArrayList<>();

        happyString(1,"",n,arr);

        if(arr.size()<k)
        return "";

        return arr.get(k-1);
    }
}