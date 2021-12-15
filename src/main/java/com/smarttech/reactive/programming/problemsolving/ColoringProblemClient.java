package com.smarttech.reactive.programming.problemsolving;

public class ColoringProblemClient {
    public static void main(String[] args) {
        int [][] matrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0}
        };

        ColoringProblem coloringProblem = new ColoringProblem(matrix, 3);
        coloringProblem.solve();
    }
}
