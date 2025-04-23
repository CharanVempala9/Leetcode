class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            int sum=0;
            int temp=i;
            while(temp>0){
                int rem=temp%10;
                sum+=rem;
                temp=temp/10;
            }
            System.out.println(sum);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
            max=Math.max(max,hm.get(sum));
        }
        int cnt=0;
        for(int val:hm.keySet()){
            if(hm.get(val)==max)
            cnt++;
        }
        return cnt;
    }
}