class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        int val=0;
        if(n%k==0)
        val=n/k;
        else
        val=n/k+1;
        String[] arr=new String[val];
        int idx=0;
        boolean found=false;
        for(int i=0; i<val; i++){
            if(idx+k<n){
                arr[i]=s.substring(idx,idx+k);
                idx+=k;
            }
            else{
                if(!found){
                StringBuilder res=new StringBuilder();
                while(idx<n){
                    res.append(s.charAt(idx));
                    idx++;
                }
                System.out.println(res.toString());
                if(res.length()<k){
                    while(res.length()<k){
                        res.append(fill);
                    }
                    if(res.length()==3)
                    found=true;
                }
                System.out.println(res.toString());
                arr[i]=res.toString();
                }
                continue;
            }
            if(found){
                StringBuilder ans=new StringBuilder();
                int ix=0;
                while(ix<k){
                    ans.append(fill);
                    ix++;
                }
                arr[i]=ans.toString();
            }
        }
        return arr;
    }
}