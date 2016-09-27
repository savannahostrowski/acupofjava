import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rarr = RotateMatrix(arr);
        for (int[] row : rarr)
            System.out.println(Arrays.toString(row));

    }
    public static int[][] RotateMatrix(int[][] arr) {
        int[][] rotatedarr = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            int[] currentRow = arr[i];

            for (int j = 0; j < currentRow.length; j++) {
                int currentElem = currentRow[j];
                rotatedarr[j][currentRow.length - i - 1] = currentElem;
            }
        }

        return rotatedarr;

    }




}