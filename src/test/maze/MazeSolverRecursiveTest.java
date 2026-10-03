package maze;

/** Runs the maze scenarios against the recursive backtracking search. */
public class MazeSolverRecursiveTest extends MazeSolverTest {

  @Override
  protected boolean hasPath(char[][] maze) {
    return MazeSolver.hasPath(maze);
  }
}
