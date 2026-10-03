package maze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The scenarios for the maze searches. A concrete subclass supplies hasPath()
 * to pick the search under test. The mazes are the ones the chapter draws.
 */
public abstract class MazeSolverTest {

  // Calls the search under test.
  protected abstract boolean hasPath(char[][] maze);

  @Test
  public void findsPathInSingleOpenCell() {
    char[][] maze = {
      {'S'},
    };
    assertTrue(hasPath(maze));
  }

  @Test
  public void returnsFalseWhenStartIsWall() {
    char[][] maze = {
      {'#', '.', '.', '#'},
      {'#', '#', '.', '#'},
      {'.', '.', '.', 'E'},
    };
    assertFalse(hasPath(maze));
  }

  @Test
  public void returnsFalseWhenExitIsWall() {
    char[][] maze = {
      {'S', '.', '.', '#'},
      {'#', '#', '.', '#'},
      {'.', '.', '.', '#'},
    };
    assertFalse(hasPath(maze));
  }

  @Test
  public void returnsFalseWhenEveryMoveLeadsBackToVisitedCells() {
    char[][] maze = {
      {'S', '.', '#'},
      {'.', '#', 'E'},
    };
    assertFalse(hasPath(maze));
  }

  @Test
  public void findsPathAroundCenterWall() {
    char[][] maze = {
      {'S', '.', '.'},
      {'.', '#', '.'},
      {'.', '.', 'E'},
    };
    assertTrue(hasPath(maze));
  }

  @Test
  public void findsPathWhenOnlyOneRouteExists() {
    char[][] maze = {
      {'S', '.', '.', '#'},
      {'#', '#', '.', '#'},
      {'.', '.', '.', 'E'},
    };
    assertTrue(hasPath(maze));
  }

  @Test
  public void returnsFalseWhenWallColumnBlocksExit() {
    char[][] maze = {
      {'S', '.', '#', '.'},
      {'#', '.', '#', '.'},
      {'.', '.', '#', 'E'},
    };
    assertFalse(hasPath(maze));
  }

  @Test
  public void findsPathAfterBackingOutOfDeadEnd() {
    char[][] maze = {
      {'S', '.', '.', '.'},
      {'.', '#', '#', '#'},
      {'.', '.', '.', 'E'},
    };
    assertTrue(hasPath(maze));
  }

  @Test
  public void findsPathAroundDeadEndInFourByFour() {
    char[][] maze = {
      {'S', '.', '.', '#'},
      {'.', '#', '.', '#'},
      {'.', '#', '#', '.'},
      {'.', '.', '.', 'E'},
    };
    assertTrue(hasPath(maze));
  }

  @Test
  public void findsPathWhenManyRoutesExist() {
    char[][] maze = {
      {'S', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.'},
      {'.', '.', '.', '.', '.'},
      {'.', '.', '.', '#', '.'},
      {'.', '.', '.', '#', 'E'},
    };
    assertTrue(hasPath(maze));
  }
}
