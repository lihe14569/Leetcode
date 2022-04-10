func getRow(rowIndex int) []int {
    prev := make([]int, rowIndex + 1)
    for i := 0; i<= rowIndex; i++ {
        row := make([]int, i + 1)
        for j := 0; j <= i; j++ {
            if j == 0 || j == i {
                row[j] = 1
            } else {
                row[j] = prev[j - 1] + prev[j]
            }
        }
        prev = row
    }
    return prev
}