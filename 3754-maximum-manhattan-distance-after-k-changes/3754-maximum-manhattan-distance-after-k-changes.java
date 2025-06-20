class Solution {
    public int maxDistance(String s, int k) {
        int length = s.length();
        int up = 0, down = 0, right = 0, left = 0;
        int maxDistance = 0;

        for (int index = 0; index < length; index++) {

            
            char direction = s.charAt(index);
            if (direction == 'N') {
                up++;
            } else if (direction == 'S') {
                down++;
            } else if (direction == 'E') {
                right++;
            } else if (direction == 'W') {
                left++;
            }
            int verticalShift = Math.abs(up - down);
            int horizontalShift = Math.abs(right - left);
            int baseDistance = verticalShift + horizontalShift;
            int interferingMoves = Math.min(up, down) + Math.min(right, left);
            int maxPossibleDistance = baseDistance + Math.min(k, interferingMoves) * 2;
            maxDistance = Math.max(maxDistance, Math.min(index + 1, maxPossibleDistance));
        }
        return maxDistance;
    
    }
}