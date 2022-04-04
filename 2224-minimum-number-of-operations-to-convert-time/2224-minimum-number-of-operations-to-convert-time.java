class Solution {
    public int convertTime(String current, String correct) {
        int diff = convertToMins(correct) - convertToMins(current);
        return diff/60 + diff % 60 /15 + diff % 15 / 5 + diff % 5;
    }
    public int convertToMins(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }
}