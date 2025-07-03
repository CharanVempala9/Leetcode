class Solution {
    public void generate(int[] candidates, int idx, int target, List<List<Integer>> ls, List<Integer> ans) {
        if (target == 0) {
            ls.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            int val = candidates[i];
            if (val > target) break;

            ans.add(val);
            generate(candidates, i + 1, target - val, ls, ans); 
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);  
        List<List<Integer>> ls = new ArrayList<>();
        generate(candidates, 0, target, ls, new ArrayList<>());
        return ls;
    }
}
