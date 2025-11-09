class Solution {
    public int countOperations(int num1, int num2) {
        int ans=0;
        while(num1>0 && num2>0){
            if(num1>num2){
                num1-=num2;
            }
            else{
                num2-=num1;
            }
            ans++;
        }
        return ans;
    }
}


/*


21 and 4   ---> 21/4= 5     21 4 --> 17 4 --? 13 4--? 9 4--> 5 4 --> 1 4 --> 
*/