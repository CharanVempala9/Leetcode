class Pair{
    String s;
    int len;
    public Pair(String s,int len){
        this.s=s;
        this.len=len;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String>hs=new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            hs.add(wordList.get(i));
        }
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        if(hs.contains(beginWord)){
            hs.remove(beginWord);
        }
        while(!q.isEmpty()){
            Pair p=q.poll();
            String t=p.s;
            int size=p.len;
            if(t.equals(endWord)) return size;
            for(int i=0; i<t.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] Rarr=t.toCharArray();
                    Rarr[i]=ch;
                    String res=new String(Rarr);
                    if(hs.contains(res)){
                        hs.remove(res);
                        q.add(new Pair(res,size+1));
                    }
                }
            }
        }
        return 0;
    }
}