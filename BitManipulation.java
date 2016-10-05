import java.util.ArrayList;

public class BitManipulation {
    public static void main (String[] args) {

        System.out.println("Binary string: " + convertToBinary(8));
        System.out.println("Number of 1s in the string: " + countOnes(convertToBinary(8)));
        System.out.println("return: " + returnSmallestLargest(8));

    }
    
    public static ArrayList<Boolean> convertToBinary(int num) {
        int temp = num;
        ArrayList<Boolean> bits  = new ArrayList<>();
        int numOfBits = 0;
        while (num > 0) {
            numOfBits++;
            num = num >> 1;
        }
        num = temp;

        for (int i = numOfBits - 1; i >= 0; i--) {
            boolean b = (num & (1 << i)) != 0;
            System.out.println("(" + num + "&(1 << " + i +"))!= 0");
            bits.add(b);
        }

        return bits;
    }

    public static int countOnes(ArrayList<Boolean> binary) {
        int numOfOnes = 0;
        for(int i = 0; i < binary.size(); i++) {

            if(binary.get(i).equals(true)) {
                numOfOnes++;
            }
        }
        return numOfOnes;
    }

    public static ArrayList<Integer> returnSmallestLargest (int num) {
        ArrayList<Integer> smallestAndLargest = new ArrayList<>();
        ArrayList<Boolean> binary = convertToBinary(num);
        int numberOfOnes = countOnes(binary);

        for (int j = num - 1; j > 0; j--) {
            ArrayList<Boolean> binaryJ = convertToBinary(j);

            int onesJ = countOnes(binaryJ);
            if (onesJ == numberOfOnes) {
                smallestAndLargest.add(j);
                break;
            }
        }

        for (int k = num + 1; k < Integer.MAX_VALUE; k++) {
            ArrayList<Boolean> binaryK = convertToBinary(k);
            int onesK = countOnes(binaryK);
            if (onesK == numberOfOnes) {
                smallestAndLargest.add(k);
                break;
            }
        }
        return smallestAndLargest;
    }
}