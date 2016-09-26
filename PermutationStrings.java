import java.util.HashMap;

public class PermutationStrings {
    public static void main(String[] args) {
        String str = "savannah";
        String str2 = "hannavas";
        String str3 = "Hannavas";
        String str4 = "William";
        String str5 = "Hanavas";

        System.out.println(isPermutation(str, str2)); //true
        System.out.println(isPermutation(str, str3)); // true
        System.out.println(isPermutation(str, str4)); // false
        System.out.println(isPermutation(str, str5)); // false
    }

    public static boolean isPermutation(String str1, String str2) {

        char[] str1char = str1.toLowerCase().toCharArray();
        char[] str2char = str2.toLowerCase().toCharArray();

        HashMap<Character, Integer> str1HM = buildMap(str1char);
        HashMap<Character, Integer> str2HM = buildMap(str2char);
        try {
            for (char k : str1HM.keySet()) {
                if (!str1HM.get(k).equals(str2HM.get(k))) {
                    return false;
                }
            }
            for (char j : str2HM.keySet()) {
                if (!str2HM.get(j).equals(str2HM.get(j))) {
                    return false;
                }
            }
        } catch (NullPointerException np) {
            return false;
        }
        return true;

    }

    public static HashMap<Character, Integer> buildMap(char[] chararr) {
        HashMap<Character, Integer> charHM = new HashMap<>();
        for (int i = 0; i < chararr.length; i++) {
            if (charHM.containsKey(chararr[i])) {
                int value = charHM.get(chararr[i]);
                charHM.replace(chararr[i], value, value + 1);
            } else {
                charHM.put(chararr[i], 1);
            }
        }
        return charHM;
    }
}