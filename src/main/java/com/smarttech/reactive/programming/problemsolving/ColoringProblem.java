package com.smarttech.reactive.programming.problemsolving;

public class ColoringProblem {
    private int numberOfVertexes;
    private int numberOfColors;
    private int[] colors;
    private int[][] adjacentMatrix;

    public ColoringProblem(int[][] adjacentVertexes, int numberOfColors) {
        this.numberOfVertexes = adjacentVertexes.length;
        this.numberOfColors =numberOfColors;
        this.colors = new int[adjacentVertexes.length];
        this.adjacentMatrix = adjacentVertexes;
    }

    public void solve() {
        if (solveProblem(0)) {
            showResults();
        } else {
            System.out.println("No solution ...");
        }
    }

    private void showResults() {
        for (int i = 0; i < this.numberOfVertexes; i++) {
            System.out.println("Node " + (i+1) + " has color index "+ colors[i]);
        }
    }

    private boolean solveProblem(int nodeIndex) {
        if (nodeIndex == numberOfVertexes) {
            return true;
        }

        for (int colorIndex = 1; colorIndex <= numberOfColors; colorIndex++) {
           if (isColorValid(colorIndex, nodeIndex)) {
               colors[nodeIndex] = colorIndex;

               if (solveProblem(nodeIndex + 1)) {
                   return true;
               }
           }
        }
        return false;
    }

    private boolean isColorValid(int colorIndex, int nodeIndex) {
        for (int i =0; i < this.numberOfVertexes; i++) {
            if (this.adjacentMatrix[nodeIndex][i] == 1 && colorIndex == colors[i]) {
                return false;
            }
        }
        return true;
    }
}
