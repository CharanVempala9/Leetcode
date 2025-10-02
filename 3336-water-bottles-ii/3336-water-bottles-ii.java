class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans=numBottles;
        int res=numExchange;
        if(numBottles < numExchange) return numBottles;
        while(numBottles >= numExchange){
            numBottles=numBottles-numExchange;
            numExchange++;
        }
        //System.out.println(numBottles +" "+numExchange);
        int temp=numBottles + numExchange-res;
        if(temp>=numExchange){
            temp=1;
        }
        else{
            temp=0;
        }
        return ans+numExchange-res+temp;
    }
}