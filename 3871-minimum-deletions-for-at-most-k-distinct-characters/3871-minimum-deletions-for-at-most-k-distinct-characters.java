class Solution {
    public int minDeletion(String s, int k) {
        int[] arr=new int[26];
        int n=s.length();
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        int cnt=0;
        ArrayList<Integer>ls=new ArrayList<>();
        for(int i=0;i<26; i++){
            if(arr[i]>0){
                ls.add(arr[i]);
                cnt++;
            }
        }
        Collections.sort(ls);
        int temp=cnt-k;
        if(temp<=0)
        return 0;
        else{
            int sum=0;
            for(int i=0; i<temp; i++){
                sum+=ls.get(i);
            }
            return sum;
        }

    }
}