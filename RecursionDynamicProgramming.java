import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RecursionDynamicProgramming {
    public static void main (String[] args) {
        System.out.println(ChildSteps(4));
        int[] dyn = new int[5];
        System.out.println(ChildStepsDyn(4, dyn));

    }

    public static int ChildSteps(int NumberOfSteps) {
        if (NumberOfSteps < 1) {
            return 0;
        } else if (NumberOfSteps == 0) {
            return 1;
        } else {
            return 1 + ChildSteps(NumberOfSteps - 1) + ChildSteps(NumberOfSteps - 2) +
                    ChildSteps(NumberOfSteps - 3);
        }
    }

    public static int ChildStepsDyn(int NumberOfSteps, int[] WaysToClimb) {
        if (NumberOfSteps < 1) {
            return 0;
        } else if (NumberOfSteps == 0) {
            return 1;
        } else {
            WaysToClimb[NumberOfSteps] = 1 +
                    ChildStepsDyn(NumberOfSteps - 1, WaysToClimb) +
                    ChildStepsDyn(NumberOfSteps - 2, WaysToClimb) +
                    ChildStepsDyn(NumberOfSteps - 3, WaysToClimb);

            System.out.println(Arrays.toString(WaysToClimb));
        }
        return WaysToClimb[NumberOfSteps];
    }

    public static ArrayList<Set<Integer>> AllSubsets(Set<Integer> set, int currentidx, Set<Integer> currentSubset) {
        if (set == null) {
            return null;
        }
        ArrayList<Set<Integer>> subsets = new ArrayList<>();
        currentSubset = new HashSet<>();


        return AllSubsets(set, currentidx + 1, currentSubset);

    }
}