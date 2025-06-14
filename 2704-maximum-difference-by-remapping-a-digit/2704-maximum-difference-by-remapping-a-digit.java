class Solution {
    public int minMaxDifference(int num) {
        String val=String.valueOf(num);
        int n=val.length();
        StringBuilder max=new StringBuilder();
        StringBuilder min=new StringBuilder();
        boolean fmax=false;
        boolean fmin=false;
        char ch1='-';
        char ch2='-';
        int i=0;
        while(i<n){
            if(val.charAt(i)!='9' && !fmax){
                ch1=val.charAt(i);
                fmax=true;
            }
            if(val.charAt(i)==ch1)
            max.append('9');
            else
            max.append(val.charAt(i));
            if(val.charAt(i)!='0' && !fmin){
                ch2=val.charAt(i);
                fmin=true;
            }
            if(val.charAt(i)==ch2)
            min.append('0');
            else
            min.append(val.charAt(i));
            i++;
        }
        int maxVal=Integer.parseInt(max.toString());
        int minVal=Integer.parseInt(min.toString());
        System.out.print(maxVal+" "+minVal);
        return maxVal-minVal;
    }
}