class Solution {
     private int sumOfSquares(int n) {
        int output = 0;
        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            output += digit;
            n /= 10;
        }
        return output;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=sumOfSquares(slow);
            fast=sumOfSquares(sumOfSquares(fast));
        }while(slow!=fast);
        if(slow==1)
        return true;
        else
        return false;
    }
}