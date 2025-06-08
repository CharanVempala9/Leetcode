class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans= new ArrayList<>();
        int count=1;
        for(int i=0; i<n ; i++)
        {
            ans.add(count);
            if(count*10<=n)
            {
                count*=10;
            }
            else{
                while(count>=n || count %10==9)
                {
                    count/=10;
                }
                count++;
            }

        }
        return ans;
        
    }
}