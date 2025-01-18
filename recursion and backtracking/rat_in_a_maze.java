import java.util.*;

public class rat_in_a_maze
{
    static void add(int row, int col, int new_row, int new_col, List<Character> temp)
    {
        if(new_row - row == 0 && new_col - col == 1)
        temp.add('R');
        else if(new_row - row == 1 && new_col - col == 0)
        temp.add('D');
        else if(new_row - row == 0 && new_col - col == -1)
        temp.add('L');
        else
        temp.add('U'); 
    }
    static boolean  check(int new_row, int new_col, int n, int m)
    {
        return new_row>=0 && new_col>=0 && new_row<n && new_col<m;
    }
    static void Paths(int[][] maze, int row, int col, List<Character> temp, List<List<Character>> ans, int n, int m)
    {
        if(row == n-1 && col == m-1)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }

        maze[row][col] = 0;

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int j=0;j<4;j++)
        {
            int new_row = row + dir[j][0];
            int new_col = col + dir[j][1];

            if(check(new_row, new_col, n, m) && maze[new_row][new_col] == 1)
            {
                add(row, col, new_row, new_col, temp);
                Paths(maze, new_row, new_col, temp, ans, n, m);
                temp.remove(temp.size()-1);
            }
        }
        maze[row][col] = 1;

    }
    static List<List<Character>> findPaths(int[][] maze)
    {
        int n = maze.length;
        int m = maze[0].length;
        if(maze[0][0] != 1 || maze[n-1][m-1] != 1)
        return new ArrayList<>();

        List<List<Character>> ans = new ArrayList<>();
        Paths(maze,0,0,new ArrayList<>(),ans,n,m);
        return ans;
    }
    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},
                        {1,1,1,0},
                        {0,1,1,1}};
        System.out.println(findPaths(maze));
    }
}