class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // Convert all dates to the absolute nth day of the year (1 - 365)
        int aliceStart = dateToDays(arriveAlice);
        int aliceEnd = dateToDays(leaveAlice);
        int bobStart = dateToDays(arriveBob);
        int bobEnd = dateToDays(leaveBob);
        
        // The overlap starts on the later arrival and ends on the earlier departure
        int overlapStart = Math.max(aliceStart, bobStart);
        int overlapEnd = Math.min(aliceEnd, bobEnd);
        
        // If overlapStart > overlapEnd, they never intersected, returning 0
        return Math.max(0, overlapEnd - overlapStart + 1);
    }
    
    // Helper method to convert "MM-DD" to an absolute day of the year
    private int dateToDays(String date) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Extract month and day using string parsing
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int totalDays = 0;
        
        // Add up all the days of the fully completed months prior to the current month
        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        
        // Add the days of the current month
        totalDays += day;
        
        return totalDays;
    }
}