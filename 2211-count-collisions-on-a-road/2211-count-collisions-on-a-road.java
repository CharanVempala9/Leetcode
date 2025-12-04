class Solution {
    public int countCollisions(String s) {
        // StringBuilder s=new StringBuilder(t);
        int n=s.length();
        int cnt=0;
        // for(int i=1; i<n; i++){
        //     if(s.charAt(i-1)=='R' && s.charAt(i)=='L'){
        //         s.setCharAt(i,'S');
        //         cnt+=2;
        //     }
        //     else if(s.charAt(i-1)=='R' && s.charAt(i)=='S'){
        //         cnt+=1;
        //     }
        //     else if(s.charAt(i-1)=='S' && s.charAt(i)=='L'){
        //         s.setCharAt(i,'S');
        //         cnt+=1;
        //     }
        // }
        // System.out.println(s.toString());
        int st=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='L'){
                st=i+1;
            }
            else{
                break;
            }
        }
        int end=n-1;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='R'){
                end=i-1;
            }
            else{
                break;
            }
        }
        System.out.println(st+" "+end);
        for(int i=st; i<=end; i++){
            if(s.charAt(i)!='S')cnt++;
        }
        return cnt;
    }
}