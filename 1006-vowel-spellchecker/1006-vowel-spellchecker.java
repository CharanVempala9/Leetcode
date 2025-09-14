class Solution {
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(Character.toLowerCase(c)) >= 0) {
                sb.append('*');
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> case_error = new HashMap<>();
        Map<String,String> vowel_error = new HashMap<>();
        for(String word: wordlist){
            String lower = word.toLowerCase();  
            String devowel = devowel(word);     
            case_error.putIfAbsent(lower,word);  
            vowel_error.putIfAbsent(devowel,word); 
        }

        String[] result = new String[queries.length];

        for(int i = 0; i < queries.length; i++){
            String query = queries[i];

            if(exact.contains(query)){        
                result[i] = query;
            }
            else{
                String lower = query.toLowerCase();  
                String devowel = devowel(query);    

                if(case_error.containsKey(lower)){  
                    result[i] = case_error.get(lower);
                }
                else if(vowel_error.containsKey(devowel)){
                    result[i] = vowel_error.get(devowel);
                }
                else{
                    result[i] = "";
                }
            }
        }
        return result;
    }
}