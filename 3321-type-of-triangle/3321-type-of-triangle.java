class Solution {
    public String triangleType(int[] nums) {
        HashSet<Integer>hs=new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        int a=nums[0];
        int b=nums[1];
        int c=nums[2];
        boolean valid=false;
        if((a+b)>c && (b+c)>a && (c+a)>b){
            valid=true;
        }
        if(valid){
        if(hs.size()==1)
        return "equilateral";
        else if(hs.size()==2)
        return "isosceles";
        return "scalene";
        }
        return "none";
    }
}