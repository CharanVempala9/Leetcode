class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        int idx = 2;
        StringBuilder res = new StringBuilder();
        res.append("1");
        while (idx <= n) {
            StringBuilder temp = new StringBuilder();
            LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
            for (int i = 0; i < res.length(); i++) {
                char ch = res.charAt(i);
                if (hm.containsKey(ch)) {
                    hm.put(ch, hm.get(ch) + 1);
                } else {
                    for (char key : hm.keySet()) {
                        temp.append(hm.get(key));
                        temp.append(key);
                    }
                    hm.clear();
                    hm.put(ch, 1);
                }
            }
            for (char key : hm.keySet()) {
                temp.append(hm.get(key));
                temp.append(key);
            }
            res = temp;
            idx++;
        }
        return res.toString();
    }
}
