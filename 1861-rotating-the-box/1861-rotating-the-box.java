class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] newBox = new char[n][m];
        
        //move the element
        for(int i = 0; i < m; i++) {
            int empty = n - 1;
            for(int j = n - 1; j >=0; j--) {
                if(box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                } else if(box[i][j] == '*') {
                    empty = j - 1;
                }
            }
        }
        
        //rotate matrix
        //step1 transpose
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                newBox[j][i] = box[i][j];
            }
        }
        //step2 reverse
        for(int i = 0; i < n; i++) {
            for(int j = 0;j < m/2; j++) {
                char temp = newBox[i][j];
                newBox[i][j] = newBox[i][m - j - 1];
                
                newBox[i][m - j - 1] = temp; 
            }
        }
        return newBox;
    }
}