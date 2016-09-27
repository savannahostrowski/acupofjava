public class ReplaceSpaces {
    public static void main (String [] args) {
        String str1 = "Mr. John Smith    ";
        System.out.println(replaceSpaces(str1));
    }

    public static String replaceSpaces(String str) {
        char[] chararr  = str.toCharArray();
        for (int i = 0; i < chararr.length; i++) {
            if (chararr[i] == ' ') {
                chararr[i] = '%';
                chararr = shuffleIndices(chararr, i + 2);
                chararr[i + 1] = '2';
                chararr[i + 2] = '0';
            }
        }
        return new String(chararr);
    }

    public static char[] shuffleIndices(char[] chararr, int idx) {
        for (int i = chararr.length - 1; i > idx; i--) {
            chararr[i] = chararr[i - 2];
        }
        return chararr;
    }

}