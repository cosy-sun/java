package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

public class D45 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int row = scanner.nextInt();

        int col = (int) Math.ceil((double) size / row);

        int[][] matrix = new int[row][col];

        handle(matrix, size);

        printMatrix(matrix);
    }

    private static void handle(int[][] matrix, int size) {
        int count = 1;
        int rowMin = 0, colMin = 0;
        int rowMax = matrix.length - 1, collaxMax = matrix[0].length - 1;

        while (rowMin <= rowMax && colMin <= collaxMax && count <= size) {
            for (int i = colMin; i <= collaxMax && count <= size; i++) {
                matrix[rowMin][i] = count++;
            }
            rowMin ++;
            for (int i = rowMin; i <= rowMax && count <= size; i++) {
                matrix[i][collaxMax] = count ++;
            }
            collaxMax --;
            for (int i = collaxMax; i >= colMin && count <= size; i --) {
                matrix[rowMax][i] = count ++;
            }
            rowMax --;
            for (int i = rowMax; i >= rowMin && count <= size; i--) {
                matrix[i][colMin] = count ++;
            }
            colMin ++;

        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(ints[j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }


}
