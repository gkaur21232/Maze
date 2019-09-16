import javax.swing.text.Position;
import java.util.Deque;
import java.util.LinkedList;
//

public class MazeSolver {
    private Maze maze;

    /** constructor**/
    public MazeSolver(Maze maze){
        this.maze = maze;
    }

    /** attempt to traverse maze
     * return true if maze has been solved
     */
    public boolean traverse(){
        boolean done = false;
        int row, column;
        Position pos = new Position();
        Deque<Position> stack = new LinkedList<Position>();
        stack.push(pos);

        while(!(done) && !stack.isEmpty()){
            pos = stack.pop();
            maze.tryPosition(pos.getx(), pos.gety());
            if(pos.getx() == maze.getRows() -1 && pos.gety() == maze.getColumns() -1)
                done = true;
            else{
                push_new_pos(pos.getx() - 1,pos.gety(), stack);
                push_new_pos(pos.getx() + 1,pos.gety(), stack);
                push_new_pos(pos.getx(),pos.gety() - 1, stack);
                push_new_pos(pos.getx(),pos.gety() + 1, stack);

            }
        }
        return done;
    }
    /** push new attempted move onto stack
     * @param x rep x coord
     * @param y rep y coord
     * @return stack of moves within the grid
     */
    private void push_new_pos(int x, int y, Deque<Position> stack){
        Position npos = new Position();
        npos.setx(x);
        npos.sety(y);
        if(maze.validPosition(x,y))
            stack.push(npos);
    }
}
