package com.smarttech.reactive.programming.problemsolving;

public class MazeProblemClient {
    public static void main(String[] args) {
        int[][] mazeTable = {
                {1, 1, 1, 1, 1 },
                {1, 0, 1, 0, 0 },
                {1, 1, 1, 0, 0 },
                {1, 0, 0, 1, 1 },
                {1, 1, 1, 1, 1 }
        };

        MazeProblem mazeProblem = new MazeProblem(mazeTable);
        mazeProblem.solve();
    }
}
