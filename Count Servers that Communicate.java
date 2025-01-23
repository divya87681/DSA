class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;       // Number of rows
        int n = grid[0].length;    // Number of columns

        int[] rowCount = new int[m]; // Array to count servers in each row
        int[] colCount = new int[n]; // Array to count servers in each column

        // Step 1: Count the number of servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Step 2: Count the servers that can communicate
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}
