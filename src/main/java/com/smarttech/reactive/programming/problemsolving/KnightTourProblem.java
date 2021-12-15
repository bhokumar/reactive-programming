package com.smarttech.reactive.programming.problemsolving;

public class KnightTourProblem {
    private int[][] solutionMatrix;
    private int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightTourProblem() {
        this.solutionMatrix = new int[Constant.BOARD_SIZE][Constant.BOARD_SIZE];
        this.initializeBoard();
    }

    private void initializeBoard() {
        for (int i =0; i < Constant.BOARD_SIZE; i++) {
            for (int j = 0; j < Constant.BOARD_SIZE; j++) {
                this.solutionMatrix[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void solveTour() {
        solutionMatrix[0][0] = 1;

        if (solve(2, 0, 0)) {
            printSolution();
        } else {
            System.out.println("No feasible solution....");
        }
    }

    private void printSolution() {
        for (int i =0; i < Constant.BOARD_SIZE; i++) {
            for (int j = 0; j < Constant.BOARD_SIZE; j++) {
                System.out.print(this.solutionMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean solve(int stepCounter, int x, int y) {
        if (stepCounter == (Constant.BOARD_SIZE * Constant.BOARD_SIZE + 1)) {
            return true;
        }

        for (int i = 0; i < Constant.NUM_OF_MOVES; i++) {
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];

            if (isStepValid(nextX, nextY)) {
                this.solutionMatrix[nextX][nextY] = stepCounter;

                if (solve(stepCounter + 1, nextX, nextY)) {
                    return true;
                }

                this.solutionMatrix[nextX][nextY] = Integer.MIN_VALUE;
            }

        }
        return false;
    }

    private boolean isStepValid(int x, int y) {
        if (x < 0 || x >= Constant.BOARD_SIZE) {
            return false;
        }

        if (y < 0 || y >= Constant.BOARD_SIZE) {
            return false;
        }

        if (solutionMatrix[x][y] != Integer.MIN_VALUE) {
            return false;
        }

        return true;
    }
}
