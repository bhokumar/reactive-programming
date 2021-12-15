package com.smarttech.reactive.programming.problemsolving;

public class HamiltonianCycle {
    private int numberOfVertexes;
    private int[] hamiltonianPath;
    private int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.hamiltonianPath = new int[adjacencyMatrix.length];
        this.numberOfVertexes = adjacencyMatrix.length;
    }

    public void solve() {
        this.hamiltonianPath[0] = 0;

        if (findFeasibleSolution(1)) {
            showHamiltonianPath();
        } else {
            System.out.println("No feasible solution ");
        }
    }

    private void showHamiltonianPath() {
        System.out.println("Hamiltonian cycle is ");
        for (int i =0; i < this.hamiltonianPath.length; i++) {
            System.out.print(this.hamiltonianPath[i] + "-->");
        }

        System.out.print(hamiltonianPath[0]);
    }

    private boolean findFeasibleSolution(int position) {
        if (position == numberOfVertexes) {
            if (this.adjacencyMatrix[hamiltonianPath[position-1]][hamiltonianPath[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }

        for (int vertexIndex = 1; vertexIndex < numberOfVertexes; vertexIndex++) {
            if (isFeasible(vertexIndex, position)) {
                hamiltonianPath[position] = vertexIndex;

                if (findFeasibleSolution(position +1)) {
                    return true;
                }

                // Backtracking

            }
        }
        return false;
    }

    private boolean isFeasible(int vertexIndex, int position) {
        // whether two nodes are connected
        if (adjacencyMatrix[position-1][vertexIndex] == 0) {
           return false;
        }

        for (int i = 0; i < position; i++) {
            if (hamiltonianPath[i] == vertexIndex) {
                return false;
            }
        }

        return true;
    }
}
