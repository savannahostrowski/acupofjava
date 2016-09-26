import java.util.ArrayList;

public class zeroMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {1, 0, 2, 3}, {0, 1, 2, 3}, {1, 2, 3, 4}};
        replace(arr);


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] rowZero(int[][] arr, ArrayList<Integer> rowsToZero) {
        for (int i = 0; i < rowsToZero.size(); i++) {
            System.out.println("This is a row :" + rowsToZero.get(i));
            for (int a = 0; a < arr[i].length; a++) {
                arr[rowsToZero.get(i)][a] = 0;

            }
        }
        return arr;
    }

    public static int[][] columnZero(int[][] arr, ArrayList<Integer> columnsToZero) {
        for (int j = 0; j < columnsToZero.size(); j++) {
            int column = columnsToZero.get(j);
            for (int k = 0; k < arr.length; k++) {
                int[] current = arr[k];
                current[column] = 0;
            }
        }
        return arr;
    }

    public static int[][] replace(int[][] arr) {
        ArrayList<Integer> rowsToZero = new ArrayList<>();
        ArrayList<Integer> columnsToZero = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] current = arr[i];
            for (int j = 0; j < current.length; j++) {
                if (current[j] == 0) {
                    rowsToZero.add(i);
                    columnsToZero.add(j);
                }
            }
        }

        rowZero(arr, rowsToZero);
        columnZero(arr, columnsToZero);
        return arr;
    }
}

