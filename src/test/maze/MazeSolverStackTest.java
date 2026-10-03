package maze;

/** Runs the maze scenarios against the explicit-stack search. */
public class MazeSolverStackTest extends MazeSolverTest {

  @Override
  protected boolean hasPath(char[][] maze) {
    return MazeSolver.hasPathWithStack(maze);
  }
}
