import java.util.*;
public class NQueens {
    //This takes check diagonal and check col operation in O(n) times
    static boolean isSafe(int row, int col, int n, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    static void find(int row, int n, char[][] board, List<List<String>> result) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] chars : board) {
                solution.add(new String(chars));
            }
            result.add(solution);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(row, i, n, board)) {
                board[row][i] = 'Q';
                find(row + 1, n, board, result);
                board[row][i] = '.';
            }
        }
    }
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        find(0, n, board, result);
        return result;
    }
    //Time Complexity = O(N!)
    static void findOpt(int row, int n, char[][] board, List<List<String>> result, boolean[] col, boolean[] leftDiagCheck, boolean[] rightDiagCheck) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] chars : board) {
                solution.add(new String(chars));
            }
            result.add(solution);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] == false && leftDiagCheck[row+i] == false && rightDiagCheck[n-1+row-i] == false) {
                col[i] = true;
                leftDiagCheck[row+i] = true;
                rightDiagCheck[n-1+row-i] = true;
                board[row][i] = 'Q';
                findOpt(row + 1, n, board, result,col,leftDiagCheck,rightDiagCheck);
                board[row][i] = '.';
                col[i] = false;
                leftDiagCheck[row+i] = false;
                rightDiagCheck[n-1+row-i] = false;
            }
        }
    }
    static List<List<String>> solveNQueensOpt(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] col = new boolean[n];
        boolean[] leftDiagCheck = new boolean[n*2-1];
        boolean[] rightDiagCheck = new boolean[n*2-1];
        findOpt(0, n, board, result, col, leftDiagCheck, rightDiagCheck);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueensOpt(4));
    }
}
