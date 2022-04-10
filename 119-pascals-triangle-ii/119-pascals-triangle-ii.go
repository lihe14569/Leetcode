func getRow(rowIndex int) []int {
    res := make([][]int, rowIndex + 1)
    
    for i := 0; i<= rowIndex; i++ {
        row := make([]int, i + 1)
        for j := 0; j <= i; j++ {
            if j == 0 || j == i {
                row[j] = 1
            } else {
                row[j] = res[i -1][j - 1] + res[i - 1][j]
            }
        }
        res[i] = row
    }
    return res[len(res) - 1]
}