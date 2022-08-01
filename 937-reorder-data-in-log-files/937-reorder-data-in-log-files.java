class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                int spaceIdx1 = s1.indexOf(' ');
                int spaceIdx2 = s2.indexOf(' ');
                
                char c1 = s1.charAt(spaceIdx1 + 1);
                char c2 = s2.charAt(spaceIdx2 + 1);
                
                if(c1 <= '9' && c2 <= '9') return 0;
                else if(c1 <= '9') return 1;
                else if(c2 <= '9') return -1;
                else {
                    int cmpStr = s1.substring(spaceIdx1 + 1).compareTo(s2.substring(spaceIdx2 + 1));
                    if(cmpStr == 0) return s1.substring(0, spaceIdx1).compareTo(s2.substring(0, spaceIdx2));
                    else return cmpStr;
                }
            }
        };
        Arrays.sort(logs, comp);
        return logs;
    }
}