class Pair{
    char ch;
    int f;
    public Pair(char ch,int f){
        this.ch=ch;
        this.f=f;
    }
}
class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.f, a.f)
);
        for(char ch:hm.keySet()){
            pq.add(new Pair(ch,hm.get(ch)));
        }
        StringBuilder res=new StringBuilder();
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int t=p.f;
            while(t-->0){
                res.append(p.ch);
            }
        }
        return res.toString();
    }
}