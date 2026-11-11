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
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Are we standing on the exit? The exit is the bottom-right cell.
  private static boolean isExit(char[][] maze, int row, int col) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // The recursive version. Returns true if there is a path from the top-left
  // cell to the bottom-right cell. Assumes maze is not null, rectangular, and
  // has at least one cell.
  public static boolean hasPath(char[][] maze) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Searches from cell (row, col) for a path to the exit, marking each cell it
  // searches from as visited.
  private static boolean search(
      char[][] maze, boolean[][] visited, int row, int col) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
