import java.util.HashSet;

public class UniqueString {
    public static void main(String[] args) {
        System.out.println(isUnique("Savannah"));
        System.out.println(isUnique("asdfgh"));
        System.out.println(isUniqueNoDS("Savannah"));
        System.out.println(isUniqueNoDS("asdfgh"));
        }
    public static boolean isUnique (String str) {
        HashSet<String> letters = new HashSet<>();
        char[] chararr = str.toCharArray();
        for (int i = 0; i < chararr.length; i++) {
            if (letters.contains(Character.toString(chararr[i]))) {
                return false;
            } else {
                letters.add(Character.toString(chararr[i]));
            }
        }
        return true;
    }

    public static boolean isUniqueNoDS(String str) {
        char[] chararr = str.toCharArray();
        for (int i = 0; i < chararr.length; i++) {
            for (int j = i + 1; j < chararr.length; j++) {
                if (chararr[i] == chararr[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}