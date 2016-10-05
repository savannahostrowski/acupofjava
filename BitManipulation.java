import java.util.ArrayList;

public class BitManipulation {
    public static void main (String[] args) {

        System.out.println("Binary string: " + convertToBinary(8));
        System.out.println("Number of 1s in the string: " + countOnes(convertToBinary(8)));
        System.out.println("return: " + returnSmallestLargest(8));

    }

    public static String convertToBinary(int num) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (num >= 1) {
            numbers.add(num % 2);
            num = num / 2;
        }
        StringBuilder builder = new StringBuilder();
        for(Integer value: numbers){
            builder.append(value.toString());
        }
        String binary = builder.reverse().toString();
        return binary;
    }

    public static int countOnes(String binary) {
        String[] result = binary.split("");
        int[] ints = new int[result.length];
        int numOfOnes = 0;
        for(int i = 0; i < result.length; i++) {
            int digit = Integer.valueOf(result[i]);
            ints[i] = digit;
            if (digit == 1) {
                numOfOnes++;
            }
        }
        return numOfOnes;
    }

    public static ArrayList<Integer> returnSmallestLargest (int num) {
        ArrayList<Integer> smallestAndLargest = new ArrayList<>();
        String binary = convertToBinary(num);
        int numberOfOnes = countOnes(binary);
        System.out.println(numberOfOnes);

        for (int j = 0; j < num; j++) {
            String binaryJ = convertToBinary(j);

            int onesJ = countOnes(binaryJ);
            if (onesJ == numberOfOnes) {
                smallestAndLargest.add(j);
                break;
            }
        }

        for (int k = num; k < Integer.MAX_VALUE; k++) {
            String binaryK = convertToBinary(k);
            int onesK = countOnes(binaryK);
            if (onesK == numberOfOnes) {
                smallestAndLargest.add(k);
                break;
            }
        }
        System.out.println("Output: " + smallestAndLargest.get(0) + " " + smallestAndLargest.get(1));
        return smallestAndLargest;
    }
}