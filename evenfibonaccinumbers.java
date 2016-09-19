public class evenfibonaccinumbers {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int sum = b;

        while (a < 4000000) {
            int tempsum = a + b;
            a = b;
            b = tempsum;
            if (b % 2 == 0) {
                sum += b;
            }
        }
        System.out.println("The sum of the even numbers is: " + sum);
    }
}

