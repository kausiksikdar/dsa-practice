public class sudoku_solver {
    // Checks if placing character 'ch' at position (row,col) is valid according to Sudoku rules
static boolean isValid(char[][] board, int row, int col, char ch) {
    // Check if 'ch' already exists in the same row
    for (int x = 0; x < 9; x++)
        if (board[row][x] == ch)
            return false;
    
    // Check if 'ch' already exists in the same column    
    for(int x = 0; x < 9; x++)
        if (board[x][col] == ch)
            return false;

    // Find the top-left corner of the 3x3 sub-grid containing (row,col)
    int a = row/3*3, b = col/3*3;
    // Check if 'ch' already exists in the 3x3 sub-grid
    for(int i = a; i < a+3; i++)
        for(int j = b; j < b+3; j++)
            if (board[i][j] == ch)
                return false;

    return true;  // If all checks pass, the placement is valid
}

// Recursive function to solve the Sudoku puzzle using backtracking
static boolean solve(char[][] board, int row, int col, int n, int m) {
    // Base case: if we've filled all rows, puzzle is solved
    if(row == n) {
        return true;
    }
    
    // If we've reached end of current row, move to next row
    if(col == m) {
        return solve(board, row+1, 0, n, m);
    }
    
    // If current cell is already filled, move to next cell
    if(board[row][col] != '.') {
        return solve(board, row, col+1, n, m);
    }

    // Try placing digits 1-9 in the current empty cell
    for(int j=1; j<=9; j++) {
        char ch = (char) ('0'+j);  // Convert digit to character
        if(isValid(board, row, col, ch)) {
            board[row][col] = ch;  // Place the digit
            
            // Recursively try to solve rest of the puzzle
            if(solve(board, row, col+1, n, m))
                return true;
                
            board[row][col] = '.';  // If placing digit didn't work, backtrack
        }
    }
    return false;  // No valid digit can be placed
}

// Main function to solve the Sudoku puzzle
public static void solveSudoku(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    solve(board, 0, 0, n, m);  // Start solving from top-left corner
}
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
            };
            solveSudoku(board);
    for (char[] board1 : board) {
        for (int j = 0; j<board[0].length; j++) {
            System.out.print(board1[j] + " ");
        }
        System.out.println();
    }
    }
}