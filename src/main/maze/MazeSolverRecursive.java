package maze;

/** The maze path problem, solved with recursive backtracking. */
public final class MazeSolverRecursive {

  private MazeSolverRecursive() {
    // This class should not be instantiated!
  }

  // Can we enter cell (row, col)? It must be inside the maze and not a wall.
  // The bounds checks come before reading maze[row][col] so a move off the
  // edge never accesses an invalid array index.
  private static boolean isOpen(char[][] maze, int row, int col) {
    return row >= 0
        && row < maze.length
        && col >= 0
        && col < maze[0].length
        && maze[row][col] != '#';
  }

  // Are we standing on the exit? The exit is the bottom-right cell.
  private static boolean isExit(char[][] maze, int row, int col) {
    return row == maze.length - 1 && col == maze[0].length - 1;
  }

  // The recursive version. Returns true if there is a path from the top-left
  // cell to the bottom-right cell. Assumes maze is not null, rectangular, and
  // has at least one cell.
  public static boolean hasPath(char[][] maze) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    return search(maze, visited, 0, 0);
  }

  // Searches from cell (row, col) for a path to the exit, marking each cell it
  // searches from as visited.
  private static boolean search(
      char[][] maze, boolean[][] visited, int row, int col) {
    if (!isOpen(maze, row, col)) {
      return false;
    }
    if (visited[row][col]) {
      return false;
    }
    if (isExit(maze, row, col)) {
      return true;
    }

    visited[row][col] = true;

    return search(maze, visited, row, col + 1)  // right
        || search(maze, visited, row + 1, col)  // down
        || search(maze, visited, row, col - 1)  // left
        || search(maze, visited, row - 1, col); // up
  }
}
