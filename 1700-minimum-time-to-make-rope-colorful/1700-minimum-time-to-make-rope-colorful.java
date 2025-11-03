class Solution {
    public int minCost(String s, int[] neededTime) {
        int n=s.length();
        int ans=0;
        int min=Integer.MAX_VALUE;
        int max=neededTime[0];
        for(int i=1; i<n; i++){
            if(s.charAt(i-1)==s.charAt(i)){
                min=Math.min(max,neededTime[i]);
                max=Math.max(max,neededTime[i]);
                //System.out.print(min+" ");
                ans+=min;
            }
            else{
                max=neededTime[i];
            }
        }
        return ans;
    }
}

/*


i need to remove the adjacent ballons that too in the minimum time. 

so if prev==curr then i should calculate the min from rhe them and remove the most time required baloon.

if a case exist aaaa  [1,20,30,40] then what will be ans 
1-> 20 -> 30 = 51
lets check my answer is correct or not in test cases;

    aaabbbabbbb
    3,5,10,7,5,3,5,5,4,8,1

    3->5->7->

*/