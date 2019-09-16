import java.util.*;
import java.io.*;
//
public class Maze {

    private static final int TRIED = 2;
    private static final int PATH = 3;

    private int numberRows, numberColumns;
    private int[][] grid;

    public Maze(String filename) throws FileNotFoundException{
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new int[numberRows][numberColumns];
        for(int i =  0; i < numberRows; i++)
            for(int j = 0; j< numberColumns; j++)
                grid[i][j] = scan.nextInt();
    }
    /** marks specified position as TRIED**/
    public void tryPosition(int row, int col){
        grid[row][col] = TRIED;
    }
    /** return number of rows in maze **/
    public int getRows(){
        return grid.length;
    }
    /** return number of columns in maze */
    public void getColumns(){
        return grid[0].length;
    }
    /** marks given position as part of PATH */
    public void markPath(int row, int col){
        grid[row][col] = PATH;
    }
    /** determines if specific location is valid. A valid spot is on that is
     * on gird, is not blocked, and has not been TRIED
     */
    public boolean validPosition(int row, int column){
        boolean result = false;
        //check if within bounds
        if(row >= 0 && grid.length &&
            column >= 0 && column < grid[row].length)
            //check if cell is not blocked nor tried
            if (grid[row][column] == 1)
                result = true;
            return result
    }
    /** returnd the maze as a string. **/
    public String toString(){
        String result = "\n";
        for(int row = 0; row < grid.length; row++)
        {
            for (int column = 0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }
        return result;
    }

}
