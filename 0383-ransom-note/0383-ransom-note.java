class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[27];
        for(int i=0; i<magazine.length(); i++){
            arr[magazine.charAt(i)-'a']++;
        }
        for(int i=0; i<ransomNote.length(); i++){
            char ch=ransomNote.charAt(i);
            if(arr[ransomNote.charAt(i)-'a']==0)
            return false;
            if(arr[ransomNote.charAt(i)-'a']>0){
                arr[ransomNote.charAt(i)-'a']--;
            }
        }
        return true;
    }
}