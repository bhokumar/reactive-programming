package com.smarttech.reactive.programming.problemsolving;

public class MazeProblem {
    private int[][] mazeTable;
    private int[][] solutionTable;
    private int mazeSize;

    public MazeProblem(int[][] mazeTable) {
        this.mazeTable = mazeTable;
        this.mazeSize = mazeTable.length;
        this.solutionTable = new int[this.mazeSize][this.mazeSize];
    }

    public void solve() {
        if (solveMaze(0, 0)) {
            showResults();
        } else {
            System.out.println("No feasible solution....");
        }
    }

    private boolean solveMaze(int x, int y) {
        if (isFinish(x, y)) {
            return true;
        }

        if (isValid(x, y)) {
            this.solutionTable[x][y] = 1;

            if (solveMaze(x + 1, y)) {
                return true;
            }

            if (solveMaze(x, y + 1)) {
                return true;
            }

            if (solveMaze(x, y - 1)) {
                return true;
            }

            if (solveMaze(x - 1, y)) {
                return true;
            }

            this.solutionTable[x][y] = 0;

            /*
            if (solveMaze(x - 1, y )) {
                return true;
            }

            if (solveMaze(x, y - 1)) {
                return true;
            }

             */
        }
        return false;
    }

    private boolean isFinish(int x, int y) {
        if (x == this.mazeSize - 1 && y == this.mazeSize -1 && this.mazeTable[x][y] == 1) {
            this.solutionTable[x][y] = 1;
            return true;
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        if (x < 0 || x >= this.mazeSize) {
            return false;
        }

        if (y < 0 || y >= this.mazeSize) {
            return false;
        }

        if (this.mazeTable[x][y] != 1) {
            return false;
        }

        if (this.solutionTable[x][y] == 1) {
            return false;
        }

        return true;
    }

    private void showResults() {
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                if (this.solutionTable[i][j] == 1) {
                    System.out.print(" s ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
