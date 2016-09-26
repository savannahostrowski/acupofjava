public class StringCompression {
    public static void main(String[] args) {
        String ogstring = "aadcccccaaa";
        System.out.println(compress(ogstring));
    }

    public static String compress(String str) {
        char[] chararr = str.toCharArray();
        String[] compressedArr = new String[chararr.length];

        char prev = chararr[0];
        int counter = 1;
        int nextspace = 0;

        for (int i = 1; i < chararr.length; i++) {

            char current = chararr[i];
            if (current == prev) {
                counter++;
            } else {
                chararr[nextspace] = prev;
                nextspace++;
                chararr[nextspace] = Integer.toString(counter).charAt(0);
                nextspace++;
                counter = 1;
                prev = current;
            }
        }
        chararr[nextspace] = prev;
        nextspace++;
        chararr[nextspace] = Integer.toString(counter).charAt(0);
        nextspace++;
        for (int j = nextspace; j < chararr.length; j++) {
            chararr[j] = 0;
        }

        return new String(chararr);
    }
}