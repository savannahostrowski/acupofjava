import java.util.Arrays;

public class ReverseNullString {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 0};
        System.out.println(Arrays.toString(arr));
        reverseNullTerminated(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] reverseNullTerminated(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[(len - 1) - i - 1];
            arr[(len - 1) - i - 1] = temp;
        }
        return arr;
    }
}