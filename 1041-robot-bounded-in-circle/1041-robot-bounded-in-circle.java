class Solution {
    public boolean isRobotBounded(String instructions) {
        //simulation north = 0, east = 1, south = 2, west = 3
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//north, south, east, west
        int x = 0, y = 0;
        int facing = 0;
        
        for(char c : instructions.toCharArray()) {
            if(c== 'L')
                facing = (facing + 3) % 4;
            else if(c == 'R')
                facing = (facing + 1) % 4;
            else{
                x += dirs[facing][0];
                y += dirs[facing][1];
            }
        }
        return (x == 0 && y == 0) || facing != 0;
    }
}