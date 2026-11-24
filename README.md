# Maze Solving

Three solutions to the maze path problem: decide whether a rectangular maze has a path from the top-left cell to the bottom-right cell. `MazeSolverRecursive` uses recursive backtracking, `MazeSolverStack` uses an explicit stack, and `MazeSolverQueue` uses a queue. A JUnit suite runs all three against the edge cases from the problem statement and a set of small mazes, most of them drawn in the chapter.

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
        MazeSolverRecursive.java        # hasPath with recursive backtracking
        MazeSolverStack.java            # hasPath with an explicit stack
        MazeSolverQueue.java            # hasPath with a queue
      stack/
        Stack.java                      # the Stack ADT contract (copied from the Stack chapter)
        ArrayStack.java                 # array-backed Stack (copied from the Stack chapter)
      queue/
        Queue.java                      # the Queue ADT contract (copied from the Queue chapter)
        LinkedQueue.java                # linked Queue (copied from the Queue chapter)
      demo/                             # one demo per solution class
        MazeSolverRecursiveDemo.java
        MazeSolverStackDemo.java
        MazeSolverQueueDemo.java
    test/
      maze/
        MazeSolverTest.java             # abstract: the maze scenarios
        MazeSolverRecursiveTest.java    # runs them against MazeSolverRecursive
        MazeSolverStackTest.java        # runs them against MazeSolverStack
        MazeSolverQueueTest.java        # runs them against MazeSolverQueue
  scripts/
    run.sh                              # compile and run one demo
    test.sh                             # compile and run every JUnit test
```

## How to compile and run

- `scripts/test.sh` — compiles everything and runs the full JUnit suite.
- `scripts/test.sh maze.MazeSolverStackTest` — compiles everything and runs only that test class. Use this while you are working on one search and the others are still empty.
- `scripts/run.sh demo.MazeSolverStackDemo` — compiles everything and runs that one demo. Every class you implement has its own demo, `<Class>Demo`.

## Contents

- `maze.MazeSolverRecursive`, `maze.MazeSolverStack`, and `maze.MazeSolverQueue` — one class per search, each with the same method, `hasPath`. The first uses recursive backtracking, the second an explicit stack, and the third a queue. A maze is a plain `char[][]`. A `'#'` is a wall; any other character is open. Coordinates are `(row, col)`, zero-indexed from the top-left.
- `maze.MazeSolverTest` — the abstract scenario suite. It has one subclass per search, so you can test one search alone.
- `stack.Stack<T>`, `stack.ArrayStack<T>`, `queue.Queue<T>`, and `queue.LinkedQueue<T>` — unchanged copies from the Stack and Queue chapters. The searches use them, so they are included here to keep this code self-contained.
- `demo.MazeSolverRecursiveDemo`, `demo.MazeSolverStackDemo`, and `demo.MazeSolverQueueDemo` — one demo per search, each on the chapter's 4x4 dead-end maze.
