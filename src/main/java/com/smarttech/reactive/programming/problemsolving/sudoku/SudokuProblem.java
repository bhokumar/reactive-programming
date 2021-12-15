package com.smarttech.reactive.programming.problemsolving.sudoku;

import com.smarttech.reactive.programming.problemsolving.Constant;

public class SudokuProblem {
    private int[][] sudokuTable;

    public SudokuProblem(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public void solveProblem() {
        if (solve(0, 0)) {
            showResults();
        } else {
            System.out.println("No feasible solution....");
        }
    }

    private void showResults() {
        for (int i = 0; i < SudokuConstants.BOARD_SIZE; i++) {
            if (i % 3 == 0) {
                System.out.println(" ");
            }

            for (int j = 0; j < SudokuConstants.BOARD_SIZE; j++) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(sudokuTable[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private boolean solve(int rowIndex, int columnIndex) {
        if (rowIndex == SudokuConstants.BOARD_SIZE && ++columnIndex == SudokuConstants.BOARD_SIZE) {
            return true;
        }

        if (rowIndex == SudokuConstants.BOARD_SIZE) {
            rowIndex = 0;
        }

        if (sudokuTable[rowIndex][columnIndex] != 0) {
            return solve(rowIndex + 1, columnIndex);
        }

        for (int number = SudokuConstants.MIN_NUMBER; number <= SudokuConstants.MAX_NUMBER; number++) {
            if (valid(rowIndex, columnIndex, number)) {
                sudokuTable[rowIndex][columnIndex] = number;

                if (solve(rowIndex + 1, columnIndex)) {
                    return true;
                }

                // BACKTRACKING
                this.sudokuTable[rowIndex][columnIndex] = 0;
            }
        }
        return false;
    }

    private boolean valid(int rowIndex, int columnIndex, int number) {

        for (int i = 0; i < SudokuConstants.BOARD_SIZE; i++) {
            if (this.sudokuTable[rowIndex][i] == number) {
                return false;
            }
        }

        for (int i = 0; i < SudokuConstants.BOARD_SIZE; i++) {
            if (this.sudokuTable[i][columnIndex] == number) {
                return false;
            }
        }

        int boxRowOffset = (rowIndex / 3) * SudokuConstants.BOX_SIZE;
        int boxColumnOffset = (columnIndex / 3) * SudokuConstants.BOX_SIZE;

        for (int i = 0; i < SudokuConstants.BOX_SIZE; i++) {
            for (int j = 0; j < SudokuConstants.BOX_SIZE; j++) {
                if (number == sudokuTable[boxRowOffset + i][boxColumnOffset + j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
