class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        // Loop through each cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Try filling only empty cells
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        // Check if num is valid at board[row][col]
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Recursively try next cell
                            if (solve(board)) return true;

                            // Backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // All cells filled correctly
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == c) return false;
            // Check column
            if (board[i][col] == c) return false;
            // Check 3x3 subgrid
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) return false;
        }
        return true;
    }
}
