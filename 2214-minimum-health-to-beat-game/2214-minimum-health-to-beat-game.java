class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int max = 0;
        long health = 1; // Since we need to be grater than 0 to beat the game at all times
        
        for(int i=0; i<damage.length;i++){
			// 1. Add all the damages to the result.
            health += damage[i];
			// 2. Find the maximum number out of damage array.
            max = Math.max(max,damage[i]);
        }
        
		// 3. To optimally use the armor, we need to use it against the that level that inflicts the most damage.
        health -= Math.min(max,armor);
        return health;
    }
}