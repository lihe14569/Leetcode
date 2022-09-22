class Solution {
     public int largestVariance(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i) - 'a');
        }
        int max = 0;
        for(int high : set) {
            
            for(int low : set) {
                if(high == low) {
                    continue;
                }
            
                int cur = 0;
                boolean hasLow = false;
                boolean startLow = false;
                
               for(int i = 0; i < s.length(); i++) {
                   if(high == (s.charAt(i) - 'a')) {
                       cur++;
                   } else if (low == (s.charAt(i) - 'a')) {
                       hasLow = true;
                       
                       if (cur >= 0 && startLow) {
                           startLow = false;
                       } else if(--cur < 0 ) {
                           startLow = true;
                           cur = -1;
                       }  
                   }
                    max = Math.max(max, hasLow? cur : 0);
                }
               
            }
        }
        return max;
        
    }
}