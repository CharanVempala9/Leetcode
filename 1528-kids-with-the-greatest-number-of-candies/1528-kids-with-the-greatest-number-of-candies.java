class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n=candies.length;
        int max=0;
        for(int i=0; i<n; i++){
           max=Math.max(candies[i],max);
        }
        List<Boolean>ls=new ArrayList<>();
        for(int candie:candies){
            if(candie+extraCandies>=max)
            ls.add(true);
            else
            ls.add(false);
        }
        return ls;
    }
}