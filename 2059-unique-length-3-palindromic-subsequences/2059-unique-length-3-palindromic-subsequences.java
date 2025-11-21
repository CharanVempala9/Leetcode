class Solution {
    // public void iscan(String s,StringBuilder t,HashSet<String>hs,int idx,int n){
    //     if(t.length()==3){
    //         if(t.charAt(0)==t.charAt(2)){
    //             hs.add(t.toString());
    //         }
    //         return;
    //     }
    //     if(t.length()>3 || idx>=n){
    //         return;
    //     }
    //     //take 
    //     t.append(s.charAt(idx));
    //     iscan(s,t,hs,idx+1,n);
    //     //not take
    //     t.deleteCharAt(t.length()-1);
    //     iscan(s,t,hs,idx+1,n);

    // }
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int  ans=0;
        for(char ch='a'; ch<='z'; ch++){
            int f=-1;
            int l=-1;
            for(int i=0; i<n; i++){
                if(s.charAt(i)==ch){
                    f=i;
                    break;
                }
            }
            for(int i=0; i<n; i++){
                if(s.charAt(i)==ch){
                    l=i;
                }
            }
            if(l!=-1 && f!=-1){
                HashSet<Character>hs=new HashSet<>();
                for(int i=f+1; i<l; i++){
                    hs.add(s.charAt(i));
                }
                ans+=hs.size();
            }
        }
        return ans;
    }
}


/*    subsequences means we are going take and not take opeartionss.....
        which is an dp... right......
    make an hashset and add them 

    a   a  b  c  a
    0   0  2  3  0

    a  a  b  c  a

    3 1 1

    b b c b a b a

    a-2      
    b-4        
    c-1





*/