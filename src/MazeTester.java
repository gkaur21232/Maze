import java.io.FileNotFoundException;
import java.util.Scanner;
//

public class MazeTester {
    /** creates a new maze, prints its original form, attempts
     * to solve it, and prints out final form.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name of file containing the maze: ")
        String filename = scan.nextLine();

        Maze labyrinth = new Maze(filename);

        System.out.println(labyrinth);

        MazeSolver solver = new MazeSolver(labyrinth);
        if(solver.traverse())
            System.out.println("the maze was succesfully traversed!");
        else
            System.out.println("No possible path.");



    }
}
