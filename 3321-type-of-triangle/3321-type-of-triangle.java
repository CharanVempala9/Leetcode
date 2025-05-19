class Solution {
    public String triangleType(int[] nums) {
        int n=nums.length;
        int a=nums[0];
        int b=nums[1];
        int c=nums[2];
        boolean valid=false;
        if((a+b)>c && (b+c)>a && (c+a)>b){
            valid=true;
        }
        int[] arr=new int[101];
        for(int i=0; i<n; i++){
            arr[nums[i]]++;
        }
        int ocnt=0;
        int tcnt=0;
        int thcnt=0;
        for(int ar: arr){
            if(ar==1)
            ocnt++;
            else if(ar==2)
            tcnt++;
            else if(ar==3)
            thcnt++;
        }
        if(!valid)
        return "none";
        else{
            if(ocnt==3)
            return "scalene";
            else if(tcnt==1)
            return "isosceles";
            return "equilateral";
        }
    }
}