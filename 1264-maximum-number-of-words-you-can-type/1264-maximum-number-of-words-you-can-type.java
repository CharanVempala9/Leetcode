class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr=text.split(" ");
        HashSet<Character>hs=new HashSet<>();
        for(int i=0; i<brokenLetters.length(); i++){
            hs.add(brokenLetters.charAt(i));
        }
        int ans=0;
        for(int i=0; i<arr.length; i++){
            boolean found=false;
            for(int j=0; j<arr[i].length(); j++){
                if(hs.contains(arr[i].charAt(j))){
                    //System.out.println(arr[i].charAt(j));
                    found=true;
                    break;
                }
            }
            if(!found)
            ans++;
        }
        return ans;
    }
}