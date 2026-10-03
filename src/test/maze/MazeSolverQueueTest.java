package maze;

/** Runs the maze scenarios against the queue search. */
public class MazeSolverQueueTest extends MazeSolverTest {

  @Override
  protected boolean hasPath(char[][] maze) {
    return MazeSolver.hasPathWithQueue(maze);
  }
}
