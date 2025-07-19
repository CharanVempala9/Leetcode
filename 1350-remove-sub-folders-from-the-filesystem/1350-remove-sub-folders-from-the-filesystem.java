class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String>res=new ArrayList<>();
        Arrays.sort(folder);
        String prev="";
        for(int i=0; i<folder.length; i++){
            String curr=folder[i];
            if(prev.length()==0 || !curr.startsWith(prev+"/")){
                res.add(curr);
                prev=curr;
            }
        }
        return res;
    }
}