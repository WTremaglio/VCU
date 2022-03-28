/**************************************************************************
 * Lab 10 - Minesweeper
 **************************************************************************
 * This program imitates a Minesweeper game.
 * ________________________________________________________________________
 * William Tremaglio
 * 03.27.2019
 * CMSC 255 Section 004
 *************************************************************************/

public class Lab-10 {
    public static void addTo10(int [][] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = 0;

            for (int j = 0; j < array[i].length; j++) {
                sum = array[i][j] + sum;
            }

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    int difference = 10 - sum;
                    array[i][j] = difference;
                    sum = sum + difference;
                }
            }
        }
        
        System.out.println(sum);
    }

    public static void setHints(int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == -1) {
                    if (isInBounds(i-1,j-1,array) && array[i-1][j-1] != -1){
                        array[i-1][j-1]++;
                    }

                    if (isInBounds(i-1,j,array) && array[i-1]) {
                        array[i - 1][j]++;

                        array[i - 1][j + 1]++;

                        array[i][j - 1]++;

                        array[i][j + 1]++;

                        array[i + 1][j - 1]++;

                        array[i + 1][j]++;

                        array[i + 1][j + 1]++;
                    }
                }
            }
        }
    }

    public static boolean isInBounds(int i, int j, int[][] board){
        return (i >= 0 && i < board.length) && (j >= 0 && j < board[i].length);
    }

    public static boolean isBomb(int value) {
        return value == -1;
    }

    public static void main(String[] args) {
        int [][] matrix = {{-1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, -1, 0, -1},
                {0, 0, 0, -1, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int [][] matrix2 = {{6, 3, 2, 0, 4}, {34, 53, 0, 23, 1}, {0, 23, 54, 11, 7}};
        int [][] matrix3 = { { 0, -1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { -1, 0, 0, 0, 0, 0 }, { -1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

        addTo10(matrix2);
        setHints(matrix);
        setHints(matrix3);
    }
}
