package com.smarttech.reactive.programming.problemsolving;

public class NQueen {
    private int[][] chessTable;
    int numberOfQueens = 0;

    public NQueen(int numberOfQueens) {
        this.chessTable = new int[numberOfQueens][numberOfQueens];
        this.numberOfQueens = numberOfQueens;
        initializeChesstable();
    }

    private void initializeChesstable() {
        for (int i=0; i < numberOfQueens; i++) {
            for(int j = 0; j < numberOfQueens; j++) {
                chessTable[i][j] = 0;
            }
        }
    }

    public void printChessTable() {
        for (int i=0; i < numberOfQueens; i++) {
            for(int j = 0; j < numberOfQueens; j++) {
                if (chessTable[i][j] == 1) {
                    System.out.print(" *");
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }
    }

    public void solveNQueen() {
        if (setQueens(0)) {
            System.out.println("N queen problem has been solved below is chess table \n");
            printChessTable();
        } else {
            System.out.println("N queen problem has not been solved!");
        }
    }

    private boolean setQueens(int colIndex) {
        if (colIndex == this.numberOfQueens) {
            return true;
        }

        for (int rowIndex = 0; rowIndex < this.numberOfQueens; rowIndex++) {
            boolean isPlaceValid = isValidPlace(rowIndex, colIndex);
            if (isPlaceValid) {
                this.chessTable[rowIndex][colIndex] = 1;

                if (setQueens(colIndex + 1)) {
                    return true;
                }

                this.chessTable[rowIndex][colIndex] = 0;
            }
        }
        return  false;
    }

    private boolean isValidPlace(int rowIndex, int colIndex) {
        for (int i =0; i < colIndex; i++) {
            if (chessTable[rowIndex][i] == 1) {
                return  false;
            }
        }

        for (int i =rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }

        for (int i = rowIndex, j = colIndex; i < this.numberOfQueens && j >= 0; i++, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
