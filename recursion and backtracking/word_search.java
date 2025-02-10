/**
* A class that implements a word search puzzle solver
* This program can find if a word exists in a 2D grid of characters
* by searching in all four directions (up, down, left, right)
*/
public class word_search {
    static boolean valid(int j, int k, int n, int m) {
        return j >= 0 && j < n && k >= 0 && k < m;
    }
    static boolean find(char[][] board, String word, int ind, int n, int m, int row, int col, boolean[][] visited) {
        // Base case: if we've matched all characters, word is found
        if(ind == word.length())
            return true;
            
        // Mark current cell as visited
        visited[row][col] = true;
        
        // Define the four possible directions: right, left, down, up
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        // Try each direction
        for(int j = 0; j < 4; j++) {
            int n_row = row + dir[j][0];
            int n_col = col + dir[j][1];
            
            // Check if next position is valid and matches next character
            if(valid(n_row, n_col, n, m) && !visited[n_row][n_col] && 
               board[n_row][n_col] == word.charAt(ind) && 
               find(board, word, ind+1, n, m, n_row, n_col, visited))
                return true;
        }
        
        // Backtrack: unmark current cell
        visited[row][col] = false;
        return false;
    }
    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        
        // Try each cell as starting point
        for(int j = 0; j < n; j++)
            for(int k = 0; k < m; k++)
                // If first character matches, start search from this cell
                if(board[j][k] == word.charAt(0)) {
                    if(find(board, word, 1, n, m, j, k, visited))
                        return true;
                }
        return false;
    }
    public static void main(String[] args) {
        // Test case 1: Word exists in snake pattern
        char[][] board1 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word1 = "ABCCED";
        System.out.println("Test case 1: " + exist(board1, word1));  // Should print true
        
        // Test case 2: Shorter word exists
        char[][] board2 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word2 = "SEE";
        System.out.println("Test case 2: " + exist(board2, word2));  // Should print true
        
        // Test case 3: Word doesn't exist (requires reuse of letter)
        char[][] board3 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word3 = "ABCB";
        System.out.println("Test case 3: " + exist(board3, word3));  // Should print false
    }
 }