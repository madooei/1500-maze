# Maze Solving

One `MazeSolver` that decides whether a rectangular maze has a path from the top-left cell to the bottom-right cell, three ways: recursive backtracking, an explicit stack, and a queue. A JUnit suite runs all three against the edge cases from the problem statement and a set of small mazes, most of them drawn in the chapter.

## Prerequisites

- JDK 17+
- The JUnit jar is already vendored in `lib/`; there is nothing to download.

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  lib/
    junit-platform-console-standalone-6.1.0.jar
  src/
    main/
      maze/
        MazeSolver.java                 # the three searches (recursion, stack, queue)
        Main.java                       # demo entry point
      stack/
        Stack.java                      # the Stack ADT contract (copied from the Stack chapter)
        ArrayStack.java                 # array-backed Stack (copied from the Stack chapter)
      queue/
        Queue.java                      # the Queue ADT contract (copied from the Queue chapter)
        LinkedQueue.java                # linked Queue (copied from the Queue chapter)
    test/
      maze/
        MazeSolverTest.java             # abstract: the maze scenarios
        MazeSolverRecursiveTest.java    # runs them against hasPath
        MazeSolverStackTest.java        # runs them against hasPathWithStack
        MazeSolverQueueTest.java        # runs them against hasPathWithQueue
  scripts/
    run.sh                              # compile and run the maze demo (maze.Main)
    test.sh                             # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh maze.MazeSolverStackTest` — compiles everything and runs only that test class. Use this while you are working on one search and the others are still empty.
- `scripts/run.sh` — compiles everything and runs the `Main` demo.

## What's here

- `maze.MazeSolver` — `hasPath` (recursive backtracking), `hasPathWithStack` (an explicit stack), and `hasPathWithQueue` (a queue). A maze is a plain `char[][]`. A `'#'` is a wall; any other character is open. Coordinates are `(row, col)`, zero-indexed from the top-left.
- `maze.Main` — a runnable demo on the chapter's 4x4 dead-end maze.
- `maze.MazeSolverTest` — the abstract scenario suite. It has one subclass per search, so you can test one search alone.
- `stack.Stack<T>`, `stack.ArrayStack<T>`, `queue.Queue<T>`, and `queue.LinkedQueue<T>` — unchanged copies from the Stack and Queue chapters. The searches use them, so they are included here to keep this code self-contained.
