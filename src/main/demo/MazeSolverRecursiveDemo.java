package demo;

import maze.MazeSolverRecursive;

/** A demo of MazeSolverRecursive on the 4x4 maze traced in the chapter. */
public final class MazeSolverRecursiveDemo {

  private MazeSolverRecursiveDemo() {
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

    // The path down the left column and along the bottom row reaches the exit. Expect true.
    System.out.println("Reaches the exit: " + MazeSolverRecursive.hasPath(maze));
  }
}
