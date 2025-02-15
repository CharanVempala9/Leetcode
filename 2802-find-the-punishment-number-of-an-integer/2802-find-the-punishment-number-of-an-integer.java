class Solution {     
    public int punishmentNumber(int n) {         
        int ans = 0;         
        for (int i = 1; i <= n; i++) {             
            int temp = i * i;             
            if (canBePartitioned(String.valueOf(temp), 0, i)) {                 
                ans += temp;             
            }         
        }         
        return ans;     
    }      
    
    private boolean canBePartitioned(String s, int index, int target) {         
        if (index == s.length()) return target == 0;         
        int num = 0;         
        for (int j = index; j < s.length(); j++) {             
            num = num * 10 + (s.charAt(j) - '0');             
            if (num > target) break;             
            if (canBePartitioned(s, j + 1, target - num)) return true;         
        }         
        return false;     
    } 
}
