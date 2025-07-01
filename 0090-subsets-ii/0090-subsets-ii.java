class Solution {
    public static boolean checkbit(int n,int i){
        return ((n>>i)&1)==0;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>>main=new ArrayList<>();
        HashSet<ArrayList<Integer>>hs=new HashSet<>();
        for(int i=0; i<(1<<n); i++){
            ArrayList<Integer>ls=new ArrayList<>();
            for(int j=0; j<n; j++){
                if(checkbit(i,j)==true)
                {
                    ls.add(nums[j]);

                }
            }
            if(!hs.contains(ls)){
            hs.add(ls);
            main.add(ls);
            }
        }
        return main;
    }
}