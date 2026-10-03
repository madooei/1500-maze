package maze;

import stack.Stack;
import stack.ArrayStack;
import queue.Queue;
import queue.LinkedQueue;

/** The maze path problem, solved with recursion, an explicit stack, and a queue. */
public final class MazeSolver {

  private MazeSolver() {
    // This class should not be instantiated!
  }

  /** A cell in the maze: a row and a column. */
  private static class Position {
    int row;
    int col;

    Position(int row, int col) {
      this.row = row;
      this.col = col;
    }
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

  // The explicit-stack version. Returns true if there is a path from the
  // top-left cell to the bottom-right cell. Assumes maze is not null,
  // rectangular, and has at least one cell.
  public static boolean hasPathWithStack(char[][] maze) {
    if (!isOpen(maze, 0, 0)) {
      return false;
    }

    boolean[][] visited = new boolean[maze.length][maze[0].length];
    Stack<Position> toExplore = new ArrayStack<>();

    toExplore.push(new Position(0, 0));
    visited[0][0] = true;

    int[] rowChange = {0, 1, 0, -1};
    int[] colChange = {1, 0, -1, 0};

    while (!toExplore.isEmpty()) {
      Position current = toExplore.top();
      toExplore.pop();

      if (isExit(maze, current.row, current.col)) {
        return true;
      }

      for (int i = 0; i < rowChange.length; i++) {
        int nextRow = current.row + rowChange[i];
        int nextCol = current.col + colChange[i];
        if (isOpen(maze, nextRow, nextCol) && !visited[nextRow][nextCol]) {
          toExplore.push(new Position(nextRow, nextCol));
          visited[nextRow][nextCol] = true;
        }
      }
    }

    return false;
  }

  // The queue version. Returns true if there is a path from the top-left cell
  // to the bottom-right cell. Assumes maze is not null, rectangular, and has
  // at least one cell.
  public static boolean hasPathWithQueue(char[][] maze) {
    if (!isOpen(maze, 0, 0)) {
      return false;
    }

    boolean[][] visited = new boolean[maze.length][maze[0].length];
    Queue<Position> toExplore = new LinkedQueue<>();

    toExplore.enqueue(new Position(0, 0));
    visited[0][0] = true;

    int[] rowChange = {0, 1, 0, -1};
    int[] colChange = {1, 0, -1, 0};

    while (!toExplore.isEmpty()) {
      Position current = toExplore.front();
      toExplore.dequeue();

      if (isExit(maze, current.row, current.col)) {
        return true;
      }

      for (int i = 0; i < rowChange.length; i++) {
        int nextRow = current.row + rowChange[i];
        int nextCol = current.col + colChange[i];
        if (isOpen(maze, nextRow, nextCol) && !visited[nextRow][nextCol]) {
          toExplore.enqueue(new Position(nextRow, nextCol));
          visited[nextRow][nextCol] = true;
        }
      }
    }

    return false;
  }
}
