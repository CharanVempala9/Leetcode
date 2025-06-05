class Solution {
    List<List<Character>> adj = new ArrayList<>();
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i = 0; i < 123; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < s1.length(); i++) {
            char u = s1.charAt(i), v = s2.charAt(i);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        StringBuilder res = new StringBuilder();
        for(char ch : baseStr.toCharArray()) {
            char minChar = DFS(ch, new int[26]);
            res.append(minChar);
        }

        return res.toString();
    }

    char DFS(char curr_char, int[] visited) {
        visited[curr_char - 'a'] = 1;
        char minChar = curr_char;
        for(char v : adj.get(curr_char)) {
            if(visited[v - 'a'] == 0) {
                minChar = (char)(Math.min(minChar - 'a', DFS(v, visited) - 'a') + 'a');
            }
        }

        return minChar;
    }
}