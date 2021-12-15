package com.smarttech.reactive.programming.problemsolving;

public class HamiltonianCycleClient {
    public static void main(String[] args) {
        int [][] matrix = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1}
        };

        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(matrix);
        hamiltonianCycle.solve();
    }
}
