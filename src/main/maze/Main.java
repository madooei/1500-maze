package maze;

/** A demo of the three maze searches on the 4x4 maze traced in the chapter. */
public final class Main {

  private Main() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    // 'S' is the start, 'E' is the exit, '#' is a wall, and '.' is an open cell.
    char[][] maze = {
      {'S', '.', '.', '#'},
      {'.', '#', '.', '#'},
      {'.', '#', '#', '.'},
      {'.', '.', '.', 'E'},
    };

    System.out.println("Maze:");
    for (int row = 0; row < maze.length; row++) {
      System.out.println(new String(maze[row]));
    }
    System.out.println();

    // The three searches explore the maze in different orders, but they agree
    // on whether the exit is reachable.
    System.out.println("Recursive search reaches the exit: " + MazeSolver.hasPath(maze));
    System.out.println("Stack search reaches the exit: " + MazeSolver.hasPathWithStack(maze));
    System.out.println("Queue search reaches the exit: " + MazeSolver.hasPathWithQueue(maze));
  }
}
