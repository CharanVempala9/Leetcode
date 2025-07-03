class Solution {
    public List<List<Integer>> generate(int[] candidates,int idx, int target,List<List<Integer>>ls,List<Integer>res){
        if(target==0){
            List<Integer>ans=new ArrayList<>(res);
            ls.add(ans);
            return ls;
        }
        if(idx==candidates.length){
            return ls;
        }
        int temp=candidates[idx];
        //pick
        if(target-temp>-1){
        res.add(temp);
        generate(candidates,idx,target-temp,ls,res);
        //not pick
        res.remove(res.size()-1);
        }
        generate(candidates,idx+1,target,ls,res);
        return ls;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ls=new ArrayList<>();
        List<Integer>res=new ArrayList<>();
        List<List<Integer>>ans=generate(candidates,0,target,ls,res);
        return ans;
    }
}