import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        List<int[]> events = new ArrayList<>();
        for (int[] m : meetings) {
            events.add(new int[]{m[0], 1});  
            events.add(new int[]{m[1] + 1, -1});
        }
        events.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        int ongoing = 0;
        int lastDay = 0;
        int meetingDays = 0;
        
        for (int[] event : events) {
            int day = event[0];
            int type = event[1];
            
            if (ongoing > 0) {
                meetingDays += day - lastDay;
            }
            ongoing += type;
            lastDay = day;
        }
        
        return days - meetingDays;
    }
}
