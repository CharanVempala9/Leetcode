class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>>res=new ArrayList<>();
        HashMap<String,ArrayList<String>>hm=new HashMap<>();
        for(String str:strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String s=new String(chars);
            if(!hm.containsKey(s)){
                hm.put(s,new ArrayList<>());
            }
            hm.get(s).add(str);
        }
        res.addAll(hm.values());
        return res;
    }
}