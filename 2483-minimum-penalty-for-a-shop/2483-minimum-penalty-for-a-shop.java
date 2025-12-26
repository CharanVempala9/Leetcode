class Solution {
    public int bestClosingTime(String s) {
        int Ncnt=0;
        int n=s.length();
        int Ycnt=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='N'){
                Ncnt++;
            }
            else{
                Ycnt++;
            }
        }
        int[] sfx=new int[n+1];
        sfx[n]=Ncnt;
        int revcnt=0;
        int min=sfx[n];
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='Y'){
                min=Math.min(min,Ncnt+revcnt+1);
                Ycnt--;
                sfx[i]=Ncnt+revcnt+1;
                revcnt++;
            }
            else{
                Ncnt--;
                min=Math.min(min,Ncnt+revcnt);
                sfx[i]=Ncnt+revcnt;
            }
        }
        //System.out.println(min);
        for(int i=0; i<=n; i++){
            //System.out.print(sfx[i]+" ");
            if(sfx[i]==min){
                return i;
            }
        }
        return -1;
    }
}
/* Y Y N Y
   3 2 1 2  1



   Y  Y Y  Y 

   4   3  2   1  


*/